package com.basejava.webapp;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File(".");
        printDirectoryStructure(file);
    }

    private static void printDirectoryStructure(File rootDir) {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryStructure(file);
                }
            }
        }
    }
}
