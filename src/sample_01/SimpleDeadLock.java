package sample_01;

/**
 * Created by N1kita on 11.01.2018.
 */
public class SimpleDeadLock {
    public static void main(String[] args) {
        final Thread[] threads = new Thread[2];
        threads[0] = new Thread(() -> {
            System.out.println("#0 join to #1");
            try {
                threads[1].join();
            } catch (InterruptedException ignore) {
                /* NOP */
            }
        });

        threads[1] = new Thread(() -> {
            System.out.println("#1 join to #0");
            try {
                threads[0].join();
            } catch (InterruptedException ignore) {
                /* NOP */
            }
        });

        threads[0].start();
        threads[1].start();
    }
}
