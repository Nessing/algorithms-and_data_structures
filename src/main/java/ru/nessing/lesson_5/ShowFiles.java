package ru.nessing.lesson_5;

import java.io.File;

public class ShowFiles {

    private static void viewFiles(File file, int level) {
        StringBuilder prefix = new StringBuilder();
            int buf = level;
            prefix.append("\t".repeat(buf));

        if (file.isFile()) {
            prefix.append("|\t");
                System.out.println(prefix + file.getName());
        } else {
            System.out.println(prefix + "- " + file.getName());
            level++;
            for (File listFile : file.listFiles()) {
                viewFiles(listFile, level);
            }
        }
    }

    public static void viewFiles(File file) {
        viewFiles(file, 0);
    }
}
