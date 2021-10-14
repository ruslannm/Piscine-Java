package edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class Convert {
    private BufferedImage image;
    private char array[][];
    private char white;
    private char black;

    public Convert(char white, char black, BufferedImage image) {
        this.white = white;
        this.black = black;
        this.image = image;
        this.array = null;
    }

    public void convertImage() {
        array = new char[image.getHeight()][image.getWidth()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if (image.getRGB(i, j) == -1) {
                    array[j][i] = white;
                } else {
                    array[j][i] = black;
                }
            }
        }
    }

    public void printImage() {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}