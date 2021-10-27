package edu.school21;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    private static String checkArgs(String[] args) {
        if (args.length != 1) {
            System.err.println("Input error!");
            System.exit(-1);
        }
        String[] arg = args[0].split("=");
        if (arg.length != 2) {
            System.err.println("Input error!");
            System.exit(-1);
        }
        if (!arg[0].equals("--current-folder")) {
            System.err.println("Input error!");
            System.exit(-1);
        }
        return arg[1];
    }

    private static File getDir(String path, boolean isAbsolute) {
        File curFolder = new File(path);
        if (isAbsolute) {
            if (!(curFolder.isAbsolute() && curFolder.exists() && curFolder.isDirectory())) {
                System.err.println("Input error!");
                System.exit(-1);
            }
        } else {
            if (!(curFolder.exists() && curFolder.isDirectory())) {
                System.err.println("Input error!");
                System.exit(-1);
            }

        }

        return curFolder;
    }

    private static File getFile(String path) {
        File curFile = new File(path);
        if (!(curFile.exists() && curFile.isFile())) {
            System.err.println("Input error!");
            System.exit(-1);
        }
        return curFile;
    }


    private static int listDir(File curFolder, boolean isRoot) {
        int sizeFolder = 0;
        File[] files = curFolder.listFiles();
        if (files == null) {
            return 0;
        }
        for (File file : files) {
            if (isRoot) {
                if (file.isDirectory()) {
                    System.out.print(file.getName());
                    System.out.printf(" %.0f KB\n", (float) listDir(file, false) / 1024.0);
                } else {
                    System.out.print(file.getName());
                    System.out.printf(" %.0f KB\n", (float) file.length() / 1024.0);
                }
            } else {
                if (file.isDirectory()) {
                    sizeFolder += listDir(file, false);
                } else {
                    sizeFolder += file.length();
                }
            }
        }
        return sizeFolder;
    }


    public static void main(String[] args) {
        File curDir = getDir(checkArgs(args), true);
        System.out.println(curDir.getAbsoluteFile());
        System.out.print("->");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.equals("exit")) {
                System.exit(0);
            } else if (str.equals("ls")) {
                listDir(curDir, true);
            } else if (str.equals("cd")) {
                curDir = getDir(curDir + "/" + scanner.next(), false);
                try {
                    System.out.println(curDir.getCanonicalFile());
                } catch (IOException e) {
                    System.err.println(e.fillInStackTrace());
                    System.exit(-1);
                }
            } else if (str.equals("mv")) {
                String source = scanner.next();
                String target = scanner.next();
                File sourceFile = getFile(curDir.getAbsolutePath() + "/" + source);
                File targetFile = new File(curDir + "/" + target);
                if (targetFile.isDirectory()) {
                    try {
                        sourceFile.renameTo(new File(targetFile.getCanonicalPath() + "/" + sourceFile.getName()));
                    } catch (IOException e) {
                        System.err.println(e.fillInStackTrace());
                        System.exit(-1);
                    }
                } else if (targetFile.exists()) {
                    System.err.println("Input error!");
                    System.exit(-1);
                } else {
                    sourceFile.renameTo(targetFile);
                }
            }
            System.out.print("->");
        }
    }
}

