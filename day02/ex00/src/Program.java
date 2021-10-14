import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    static FileInputStream signatureFile;
    static FileOutputStream resultFile;
    static Map<String, String> token = new HashMap<String, String>();
    static String buffer;

    static void readSignatureFile() {
        try {
            Scanner input = new Scanner(signatureFile);
            String line, key, value;
            while (input.hasNextLine()) {
                line = input.nextLine();
                key = line.substring(line.indexOf(',') + 1).replaceAll("\\s", "");
                value = line.substring(0, line.indexOf(','));
                token.put(key, value);
            }
            input.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static final char[] HEX_SIMBOL = "0123456789ABCDEF".toCharArray();

    static String getHex(byte[] bytes) {
        int value;
        char[] hex = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            value = bytes[i] & 0xFF;
            System.out.println("bytes[i] & 0xFF = value " + bytes[i] +" "+ 0xFF + " "+ value);
            System.out.println("value >> 4 " + (value >> 4) );
            System.out.println("value & 0x0F " + (value & 0x0F) );

            hex[i * 2] = HEX_SIMBOL[value >> 4];
            hex[i * 2 + 1] = HEX_SIMBOL[value & 0x0F];
        }
        return new String(hex);
    }

    static boolean readFile() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        if (line.equals("42")) {
            System.exit(0);
        }
        try {
            FileInputStream signatureFIS = new FileInputStream(line);
            byte[] magic = new byte[8];
            signatureFIS.read(magic);
            signatureFIS.close();
            buffer = getHex(magic);
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    static boolean checkFormat() {
        for (Map.Entry<String, String> pair : token.entrySet()) {
            if (buffer.lastIndexOf(pair.getKey()) != -1) {
                buffer = pair.getValue();
                System.out.println("PROCESSED");
                return true;
            }
        }
        System.out.println("UNDEFINED");
        return false;
    }

    static void writeFile() {
        try {
            resultFile.write(buffer.getBytes());
            resultFile.write('\n');
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            signatureFile = new FileInputStream("signature.txt");
            resultFile = new FileOutputStream("result.txt");
        } catch (Exception e) {
            System.err.println(e);
        }
        readSignatureFile();
        while (true) {
             if (readFile()) {
                 if (checkFormat()) {
                     writeFile();
                 }
             }
        }

    }
}
