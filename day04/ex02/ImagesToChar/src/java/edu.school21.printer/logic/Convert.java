package edu.school21.printer.logic;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Convert {
    private final BufferedImage image;
    private Attribute[][] array;
    private final Attribute white;
    private final Attribute black;

    public Convert(String white, String black, BufferedImage image) {
        this.white = getColorCode(white);
        this.black = getColorCode(black);
        this.image = image;
        this.array = null;
    }

    public void convertImage() {
        array = new Attribute[image.getHeight()][image.getWidth()];
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
                System.out.print(Ansi.colorize(" ", array[i][j]));
            }
            System.out.println();
        }
    }

    private Attribute getColorCode(String color) {
        final String[] COLORS = {"BLACK", "RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "CYAN", "WHITE"};
        final Attribute[] COLORS_ATTR = {Attribute.BLACK_BACK(), Attribute.RED_BACK(), Attribute.GREEN_BACK(),
                Attribute.YELLOW_BACK(), Attribute.BLACK_BACK(), Attribute.MAGENTA_BACK(),
                Attribute.CYAN_BACK(), Attribute.WHITE_BACK()};
        int index = Arrays.asList(COLORS).indexOf(color);
        return COLORS_ATTR[index];
    }
}
