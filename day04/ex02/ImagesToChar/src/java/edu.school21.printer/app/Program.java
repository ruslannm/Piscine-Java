package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.*;

import com.beust.jcommander.JCommander;

public class Program {
    private static final String PATH = "/resources/image.bmp";

    public static void main(String[] args) {
        String white, black;
        BufferedImage image;

        if (args.length != 2) {
            System.err.println("Usage: Program --white=RED --black=GREEN");
            System.exit(-1);
        }
        Args arguments = new Args();
        try {
            JCommander.newBuilder()
                    .addObject(arguments)
                    .build()
                    .parse(args);
        } catch (Exception e) {
            System.err.println("Usage: Program --white=RED --black=GREEN");
            System.exit(-1);

        }
        if (!arguments.isValid()) {
            System.err.println("Usage: Program --white=RED --black=GREEN");
            System.exit(-1);
        }
        white = arguments.getWhite();
        black = arguments.getBlack();
        image = null;
        try {
            URL imageUrl = Program.class.getResource(PATH);
            if (imageUrl == null) {
                System.err.println("Error file");
                System.exit(-1);
            }
            image = ImageIO.read(imageUrl);
        } catch (IOException e) {
            System.err.println("Error file");
            System.exit(-1);
        }
        Convert convert = new Convert(white, black, image);
        convert.convertImage();
        convert.printImage();
    }
}