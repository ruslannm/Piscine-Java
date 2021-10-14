import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    private static final String ARG_NAME = "--threadsCount";
    private static final String FILE_URLS = "files_urls.txt";
    private static List<String> urlList = null;

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Usage: Program " + ARG_NAME + "=3");
            System.exit(-1);
        }
        String[] arg = args[0].split("=");
        if (!arg[0].equals(ARG_NAME) || arg.length != 2 || !arg[1].matches("\\d++")) {
            System.err.println("Usage: Program " + ARG_NAME + "=3");
            System.exit(-1);
        }
        int threadsCount = Integer.parseInt(arg[1]);
        try (Stream<String> lines = Files.lines(Paths.get(FILE_URLS))) {
            urlList = lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Failed to load file." + e);
            System.exit(-1);
        }
        CounterUrls counterUrls = new CounterUrls(urlList.size());
        for (int i = 1; i <= threadsCount; i++) {
            Thread urlThread = new Thread(new MyRunnable(i, urlList, counterUrls));
            urlThread.start();
        }
    }

}