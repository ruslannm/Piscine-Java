public class MyRunnable implements Runnable {
    private final String text;
    private final int count;

    public MyRunnable(String text, int count) {
        this.text = text;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }

    }
}
