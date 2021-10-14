public class SynchronizedResponse {
    private String text;

    public SynchronizedResponse(String text) {
        this.text = text;
    }

    public synchronized void say(String text) {
        while (this.text.equals(text)) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println(text);
        this.text = text;
        notify();
    }
}
