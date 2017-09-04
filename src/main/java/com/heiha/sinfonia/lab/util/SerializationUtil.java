package com.heiha.sinfonia.lab.util;

import java.io.*;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/4 10:21<br>
 * <b>Author:</b> heiha<br>
 */
public class SerializationUtil {
    public static void serialize(Object object, String path) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
    }

    public static Object deserialize(File file) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
            return objectInputStream.readObject();
        }
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return objectInputStream.readObject();
        }
    }
}
