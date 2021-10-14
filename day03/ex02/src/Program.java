import java.util.Random;

public class Program {
    private static final String[] ARG_NAMES = {"--arraySize", "--threadsCount"};
    private static final int MAX_MODULO = 1_000;
    private static final int MAX_ARRAY_SIZE = 2_000_000;
    private static int[] argNumber = {-1, -1};


    public static void main(String[] args) throws InterruptedException {
        parseArg(args);
        int[] array = new int[argNumber[0]];
        int sum = 0;
        int sumOfTreads = 0;
        Random random = new Random();
        for (int i = 0; i < argNumber[0]; i++) {
            array[i] = random.nextInt(2 * MAX_MODULO + 1) - MAX_MODULO;
            sum += array[i];
        }
        System.out.println("Sum: " + sum);
        SumByTreads sumByTreads = new SumByTreads();
        int remainder = argNumber[0] % argNumber[1];
        int division = argNumber[0] / argNumber[1];
        int i = 0;
        int j = 0;
        if (remainder == 0) {
            for (i = 0; i < argNumber[1]; i++, j += division) {
                Thread sumTread = new Thread(new MyRunnable(i, j, j + division, array, sumByTreads));
                sumTread.start();
                sumTread.join();
            }
        } else {
            division += 1;
            for (i = 0; i < argNumber[1] - 1; i++, j += division) {
                Thread sumTread = new Thread(new MyRunnable(i, j, j + division, array, sumByTreads));
                sumTread.start();
                sumTread.join();
            }
            Thread sumTread = new Thread(new MyRunnable(i, j, argNumber[0], array, sumByTreads));
            sumTread.start();
            sumTread.join();
        }
        System.out.println("Sum by threads: " + sumByTreads.getSum());
    }

    private static boolean isValid(String arg, int[] argNumber) {
        int i;
        String[] arrayArg = arg.split("=");
        if (arrayArg.length != 2 || !arrayArg[1].matches("\\d++")) {
            return false;
        }
        for (i = 0; i < ARG_NAMES.length; i++) {
            if (arrayArg[0].equals(ARG_NAMES[i])) {
                argNumber[i] = Integer.parseInt(arrayArg[1]);
                return true;
            }
        }
        return false;
    }

    private static void parseArg(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: Program " + ARG_NAMES[0] + "=13 " + ARG_NAMES[1] + "=3");
            System.exit(-1);
        }
        if (!(isValid(args[0], argNumber) && isValid(args[1], argNumber))) {
            System.err.println("Usage: Program " + ARG_NAMES[0] + "=13 " + ARG_NAMES[1] + "=3");
            System.exit(-1);
        }
        if (argNumber[0] == -1 || argNumber[1] <= 0 || argNumber[1] > argNumber[0]
                || argNumber[0] > MAX_ARRAY_SIZE) {
            System.err.println("Usage: Program " + ARG_NAMES[0] + "=13 " + ARG_NAMES[1] + "=3");
            System.exit(-1);
        }
    }
}