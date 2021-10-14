package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.*;

public class Program {
    private static final String PATH = "/resources/image.bmp";

    public static void main(String[] args) {
        char[][] arr;
        char white, black;
        BufferedImage image;

        if (args.length != 2) {
            System.err.println("Usage: Program <white> <black>");
            System.exit(-1);
        }
        white = args[0].toCharArray()[0];
        black = args[1].toCharArray()[0];
        image = null;
        try {
            URL imageUrl = Program.class.getResource(PATH);
            image = ImageIO.read(imageUrl);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }
        Convert convert = new Convert(white, black, image);
        convert.convertImage();
        convert.printImage();
    }
}