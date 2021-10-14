import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int number = 0;
        int count = 0;

        Scanner input = new Scanner(System.in);

        while (number != 42) {
            number = input.nextInt();
            if (isPrime(sumOfDigits(number))) {
                count++;
            }
        }
        input.close();
        System.out.println("Count of coffee-request - " + count);
    }

    static int sumOfDigits(int number) {
        int sum;

        for (sum = 0; number > 0; number /= 10) {
            sum += number % 10;
        }
        return sum;
    }

    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}
