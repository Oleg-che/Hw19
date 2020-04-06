package com.cherednik;

import java.io.File;
import java.util.Objects;

public class Task1 {

    public static void main(String[] args) {
        File directory = new File("D:\\File\\Hw19");
        getNameFile(directory);
    }
    private static void getNameFile(File directory) {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                getNameFile(new File(file.getAbsolutePath()));
            } else {
                System.out.println(file.getName());
            }
        }
    }
}
