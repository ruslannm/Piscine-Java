public class SumByTreads {
    private int sum;

    public SumByTreads() {
        this.sum = 0;
    }

    public synchronized void add(int sum) {
        this.sum += sum;
    }

    public int getSum() {
        return sum;
    }
}
