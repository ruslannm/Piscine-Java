import java.util.Scanner;

public class Program {
    static final int MAX_CODE = 65535;
    static final int TOP = 10;
    static final int LIMIT_SCALE = 10;

    public static void main(String[] args) {

        int i, j, curChar, curCount, maxCount;
        int[] charInStr = new int[MAX_CODE];
        int[] chars = new int[TOP];
        int[] counts = new int[TOP];
        int[] scale = new int[TOP];

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();

        for (char c : str.toCharArray()) {
            charInStr[c]++;
        }

        for (i = 0; i < TOP; i++) {
            curChar = 0;
            curCount = 0;
            for (j = 0; j < MAX_CODE; j++) {
                if (charInStr[j] > curCount) {
                    curCount = charInStr[j];
                    curChar = j;
                }
            }
            chars[i] = curChar;
            counts[i] = curCount;
            charInStr[curChar] = 0;
        }
        maxCount = counts[0];
        if (maxCount <= 0) {
            return;
        }
        if (counts[0] < LIMIT_SCALE) {
            for (i = 0; i < TOP; i++) {
                scale[i] = counts[i];
            }
        } else {
            for (i = 0; i < TOP; i++) {
                scale[i] = counts[i] * LIMIT_SCALE / maxCount;
            }
            maxCount = LIMIT_SCALE;
        }
        for (i = maxCount; i >= 0; i--) {
            for (j = 0; j < TOP; j++) {
                if (counts[j] == 0) {
                    continue;
                }
                if (i > scale[j]) {
                    System.out.print("   ");
                } else if (i == scale[j]) {
                    System.out.printf("%3d", counts[j]);
                } else {
                    System.out.print("  #");
                }
            }
            System.out.println();
        }
        for (i = 0; i < TOP; i++) {
            System.out.print("  " + (char) chars[i]);
        }
        System.out.println();
    }
}
