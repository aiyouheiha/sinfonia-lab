package com.heiha.sinfonia.lab.util;

import java.io.*;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/5 14:59<br>
 * <b>Author:</b> heiha<br>
 */
public class FormatUtil {
    public static void format(File inputFile, int... rows) throws IOException {
        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            char[] chars = line.toCharArray();
            StringBuffer sb = new StringBuffer();
            int count = 0;
            int index = 0;
            while (index < chars.length) {
                index = toSplit(chars, index, sb, rows, count);
                count ++;
            }
            System.out.println(sb.toString());
        }

    }

    public static void format(File inputFile, File outputFile, int... rows) throws IOException {
        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile, true)));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            char[] chars = line.toCharArray();
            StringBuffer sb = new StringBuffer();
            int count = 0;
            int index = 0;
            while (index < chars.length) {
                index = toSplit(chars, index, sb, rows, count);
                count ++;
            }

            bufferedWriter.write(sb.append("\n").toString());
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int toSplit(char[] chars, int start, StringBuffer sb, int[] rows, int count) {
        if (inDelRows(rows, count)) {
            sb = new StringBuffer();
        }
        boolean jump = false;
        while (start < chars.length) {
            if (chars[start] == '\'') {
                jump = !jump;
            }
            if (chars[start] == ',' && !jump)
                break;
            sb.append(chars[start]);
            start ++;
        }
        sb.append(',');
        return start + 1;
    }

    public static boolean inDelRows(int[] rows, int count) {
        for (int row : rows) {
            if (count == row)
                return true;
        }
        return false;
    }

    public static String getKeyCertString(File file) throws IOException {
        try (
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                ) {
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\\r\\n");
            }
            return sb.toString();
        }
    }

    public static String jsonKeyCert(String keyPath, String certPath) throws IOException {
        File key = new File(keyPath);
        File crt = new File(certPath);
        StringBuffer sb = new StringBuffer();
        sb.append("{\"https\": {");
        sb.append(" \"enable\": true,");
        sb.append("\"crt\": \"").append(getKeyCertString(crt)).append("\"").append(",");
        sb.append("\"key\": \"").append(getKeyCertString(key)).append("\"");
        sb.append("}}");

//        // via http "+" might become " ", if this status happened, change "+" to "%2B"
//        return sb.toString().replace("+", "%2B");
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {

    }
}
