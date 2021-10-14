public class MyTread extends Thread {
    private final String text;
    private final int count;

    public MyTread(String text, int count) {
        this.text = text;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }

    }
}
