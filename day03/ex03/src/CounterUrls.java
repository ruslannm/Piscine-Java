public class CounterUrls {
    private int counter;
    private int size;

    public CounterUrls(int size) {
        this.counter = 1;
        this.size = size;
    }

    public synchronized int getCounter() {
        if (counter <= size) {
            return counter++;
        }
        return 0;
    }
}
