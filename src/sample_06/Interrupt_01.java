package sample_06;

/**
 * @author Mykyta Shvets
 * @since 2018-01-21.
 */
public class Interrupt_01 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello");
                    for (int i = 0; i < 1_000_000_000; i++) ;
                }
            }
        });

        thread.start();

        //Deprecated, throw ThreadDeath (ext. Error).
        thread.stop();
        //Deprecated, throw new NoSuchMethodError();
        thread.destroy();
        //Deprecated, can lead to DeadLock
        thread.suspend();
        //Deprecated
        thread.resume();
    }
}
