import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int number;
        int step = 1;

        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()) {
            System.err.println("Illegal Argument");
            input.close();
            System.exit(1);
        }

        number = input.nextInt();
        input.close();
        if (number < 2) {
            System.err.println("Illegal Argument");
            System.exit(1);
        } else if (number < 4) {
            System.out.println("true " + step);
        } else {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    System.out.println("false " + step);
                    return;
                }
                step++;
            }
            System.out.println("true " + step);
        }
    }
}
