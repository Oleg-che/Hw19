package com.cherednik;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    private static final String INPUT_URL = "https://dl.dropboxusercontent.com/s/5y76skm8f5ged7j/src.zip";
    private static final String FILE_LOCATION = "D:\\File";

    public static void main(String[] args) throws IOException {

            try (ZipInputStream zin = new ZipInputStream(new FileInputStream(FILE_LOCATION + "/src.zip"))) {
                ZipEntry entry;
                String name;
                while ((entry = zin.getNextEntry()) != null) {
                    name = entry.getName();
                    FileOutputStream font = new FileOutputStream(FILE_LOCATION + name);
                    for (int c = zin.read(); c != -1; c = zin.read()) {
                        font.write(c);
                    }
                    font.flush();
                    zin.closeEntry();
                    font.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

//            java.net.URL url = new URL(INPUT_URL);
//            URLConnection connection = url.openConnection();
//            InputStream inputStream = connection.getInputStream();
//            Files.copy(inputStream, new File(FILE_LOCATION + "\\src.zip").toPath());



    }
}
