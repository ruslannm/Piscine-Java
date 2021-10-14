public class Program {

    public static void main(String[] args) {
        int number = 123456;
        int sum;

        for (sum = 0; number > 0; number /= 10) {
            sum += number % 10;
        }

        System.out.println(sum);
    }
}
