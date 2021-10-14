public class Program {
    private static final String ARG_NAME = "--count";

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Usage: Program " + ARG_NAME + "=<number of response>");
            System.exit(-1);
        }
        String[] arg = args[0].split("=");
        if (!arg[0].equals(ARG_NAME) || arg.length != 2 || !arg[1].matches("\\d++")) {
            System.err.println("Usage: Program " + ARG_NAME + "=<number of response>");
            System.exit(-1);
        }
        int count = Integer.parseInt(arg[1]);
        Thread egg = new Thread(new MyRunnable("Egg", count));
        Thread hen = new Thread(new MyRunnable("Hen", count));
        egg.start();
        hen.start();
        egg.join();
        hen.join();
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
