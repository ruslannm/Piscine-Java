package edu.school21.printer.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.Arrays;

@Parameters(separators = "=")
public class Args {
    @Parameter(names = {"--white"},
            required = true)
    private String white;
    @Parameter(names = {"--black"},
            required = true)
    private String black;

    public boolean isValid() {
        final String[] COLORS = {"BLACK", "RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "CYAN", "WHITE"};

        if (Arrays.asList(COLORS).contains(getWhite()) && Arrays.asList(COLORS).contains(getBlack())) {
            return true;
        }
        System.out.println("Valid colors:");
        for (String color : COLORS) {
            System.out.print(color + " ");
        }
        System.out.println("");
        return false;
    }

    public String getWhite() {
        if (white == null) {
            return "";
        }
        return white;
    }

    public String getBlack() {
        if (black == null) {
            return "";
        }
        return black;
    }
}
