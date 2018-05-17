package sample_01;

/**
 * Created by N1kita on 12.01.2018.
 */
public class Multithreading_06 {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(new WorkerRunnable());
        worker.start();
        worker.join();
        System.out.println("That's all!");
    }

}

class WorkerRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();

            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();

            try {
                threadA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                threadB.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("------");
            Runnable printerC = new PrintRunnable("  C", 100);
            Thread threadC = new Thread(printerC);
            threadC.start();
            try {
                threadC.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("------");
        }
    }
}
