package com.basejava.webapp;

import java.io.File;

public class FileClassTest {
    public static void main(String[] args) {
        File file = new File("/home/glebcoder/basejava");
        getAllFiles(file);
    }

    private static void getAllFiles(File rootDir) {
        File[] files = rootDir.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
            } else {
                getAllFiles(file);
            }

        }
    }
}
