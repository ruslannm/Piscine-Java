import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class Program {

    private static final String DICTIONARY_FILE = "dictionary.txt";

    static void read_files(String filenameA, String filenameB, TreeSet<String> dictionary,
                           Vector<String> wordsA, Vector<String> wordsB) throws IOException {
        String tmp;
        BufferedReader reader;
        FileInputStream fileA = new FileInputStream(filenameA);
        FileInputStream fileB = new FileInputStream(filenameB);

        reader = new BufferedReader(new InputStreamReader(fileA));
        while ((tmp = reader.readLine()) != null) {
            dictionary.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
            wordsA.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
        }
        reader = new BufferedReader(new InputStreamReader(fileB));
        while ((tmp = reader.readLine()) != null) {
            dictionary.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
            wordsB.addAll(Arrays.stream(tmp.split(" ")).collect(Collectors.toList()));
        }

        FileOutputStream dictionaryFile = new FileOutputStream(DICTIONARY_FILE);
        for (String word : dictionary) {
            dictionaryFile.write(word.getBytes());
            dictionaryFile.write(' ');
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Input error!");
            System.exit(-1);
        }

        TreeSet<String> dictionary = new TreeSet<>();
        Vector<String> wordsA = new Vector<>();
        Vector<String> wordsB = new Vector<>();
        Vector<Integer> countWordsA = new Vector<>();
        Vector<Integer> countWordsB = new Vector<>();
        int numerator = 0;
        int squareModuleA = 0;
        int squareModuleB = 0;
        int countA;
        int countB;

        read_files(args[0], args[1], dictionary, wordsA, wordsB);

        for (String word : dictionary) {
            countA = (int) wordsA.stream().filter(str -> str.equals(word)).count();
            countB = (int) wordsB.stream().filter(str -> str.equals(word)).count();
            countWordsA.add(countA);
            countWordsB.add(countB);
        }

        for (int i = 0; i < dictionary.size(); i++) {
            numerator += countWordsA.get(i) * countWordsB.get(i);
        }
        for (int value : countWordsA) {
            squareModuleA += Math.pow(value, 2);
        }
        for (int value : countWordsB) {
            squareModuleB += Math.pow(value, 2);
        }
        if (numerator == 0 || squareModuleA == 0 || squareModuleB == 0) {
            System.out.printf("Similarity = %.2f\n", 0.);
        } else {
            double result = numerator / (Math.sqrt(squareModuleA) * Math.sqrt(squareModuleB));

            result = Math.floor((result + 0.0005) * 100)/100.0;               
            System.out.printf("Similarity = %.2f\n", result);
        }
    }

}
