package sample_06;

/**
 * @author Mykyta Shvets
 * @since 2018-01-21.
 */
public class Interrupt_02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread myThread = Thread.currentThread();
                while (true) {
                    System.out.println(myThread.isInterrupted());
//                    for (int i = 0; i < 1_000_000_000; i++) ;
                    try {
                        Thread.sleep(1_000_000_000);
                    } catch (InterruptedException e) {
                        System.out.println("Bye!");
                        break;
                    }
                }
            }
        });
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
    }
}
