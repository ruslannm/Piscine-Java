public class MyRunnable implements Runnable {
    private String text;
    private int count;
    private SynchronizedResponse syncResponse;

    public MyRunnable(String text, int count, SynchronizedResponse syncResponse) {
        this.text = text;
        this.count = count;
        this.syncResponse = syncResponse;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            syncResponse.say(text);
        }
    }
}
