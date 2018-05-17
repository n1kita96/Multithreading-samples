package sample_01;

/**
 * Created by N1kita on 11.01.2018.
 */
public class Multithreading_02 {
    public static final int N = 100_000_000;
    public static int counter = 0;

    public synchronized static void inc(){
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                inc();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                inc();
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter); //200_000_000
    }
}
