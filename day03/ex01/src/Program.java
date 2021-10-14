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
        SynchronizedResponse syncResponse = new SynchronizedResponse("Hen");
        Thread egg = new Thread(new MyRunnable("Egg", count, syncResponse));
        Thread hen = new Thread(new MyRunnable("Hen", count, syncResponse));
        egg.start();
        hen.start();
    }

}
