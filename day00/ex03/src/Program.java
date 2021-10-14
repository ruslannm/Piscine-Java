import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        final int MAX_WEEK = 3;
        final String END_INPUT = "42";
        final String START_WEEK = "Week";
        int week;
        String str;
        int tmp;
        int minValue = 1;
        int value = 0;
        int offset = 1;

        Scanner input = new Scanner(System.in);
        for (week = 1; week <= MAX_WEEK; week++) {
            str = input.next();
            if (END_INPUT.equals(str)) {
                input.close();
                printResult(week, value);
                return;
            } else if (!START_WEEK.equals(str)) {
                input.close();
                printErr();
            }
            if (!input.hasNextInt()) {
                input.close();
                printErr();
            }
            tmp = input.nextInt();
            if (tmp != week) {
                input.close();
                printErr();
            }
            for (int i = 1; i <= 5; i++) {
                if (!input.hasNextInt()) {
                    input.close();
                    printErr();
                }
                tmp = input.nextInt();
                if (tmp < 1) {
                    input.close();
                    printErr();
                }
                if (i == 1) {
                    minValue = tmp;
                } else {
                    minValue = minInt(minValue, tmp);
                }
            }
            value = value + minValue * offset;
            offset *= 10;
        }
        input.close();
        printResult(week, value);
    }

    public static int minInt(int a, int b) {
        return (a < b) ? a : b;
    }

    public static void printErr() {
        System.err.println("IllegalArgument");
        System.exit(-1);
    }

    public static void printResult(int week, int result) {
        int weekResult;
        for (int i = 1; i < week; i++) {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            weekResult = result % 10;
            result /= 10;
            for (int j = 0; j < weekResult; j++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}
