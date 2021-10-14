import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Program {
    public static void main(String[] args) {
        char[][] arr;
        char white, black;
        String path;
        BufferedImage image;

        if (args.length != 3) {
            System.err.println("Usage: Program <white> <black> <path>");
            System.exit(-1);
        }
        white = args[0].toCharArray()[0];
        black = args[1].toCharArray()[0];
        image = null;
        path = args[2];
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }
        Convert convert = new Convert(white, black, image);
        convert.convertImage();
        convert.printImage();
    }
}