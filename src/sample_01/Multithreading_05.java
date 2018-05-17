package sample_01;

/**
 * Created by N1kita on 12.01.2018.
 */
public class Multithreading_05 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            /**used PrintRunnable from Multithreading_03.java*/
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();

            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();

            threadA.join();
            threadB.join();

            System.out.println("------");
            Runnable printerC = new PrintRunnable("  C  ", 100);
            printerC.run();
            System.out.println("------");
        }

    }
}
