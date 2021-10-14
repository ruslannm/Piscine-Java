public class MyRunnable implements Runnable {
    private int id;
    private int first;
    private int last;
    private int[] array;
    private SumByTreads sumByTreads;

    public MyRunnable(int id, int first, int last, int[] array, SumByTreads sumByTreads) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.array = array;
        this.sumByTreads = sumByTreads;
    }

    public void run() {
        int sum = 0;
        for (int i = first; i < last; i++) {
            sum += array[i];
        }
        System.out.println("Thread " + id + ": from " + first + " to " + (last - 1) + " sum is " + sum);
        sumByTreads.add(sum);
    }
}
