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

    public static void main(String[] args) throws IOException {
        File file = new File("");
        File file1 = new File("");
        FormatUtil.format(file, file1, 10);
    }
}
