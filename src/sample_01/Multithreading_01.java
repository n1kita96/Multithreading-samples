package sample_01;

/**
 * Created by N1kita on 11.01.2018.
 */
public class Multithreading_01 {
    public static final int N = 100_000_000;
    public static /*volatile*/ int counter = 0; //in case volatile variable take place "lost update" problem

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter); //unpredictable number > N
    }
}
