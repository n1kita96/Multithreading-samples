package sample_03;

/**
 * @author Mykyta Shvets
 * @since 17.01.2018.
 */
public class Consumer<T> implements Runnable {
    private final SingleElementBuffer<T> buffer;

    public Consumer(SingleElementBuffer<T> buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        while (true) {
            try {
                T elem = buffer.get();
                System.out.println(elem + " consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped");
                return;
            }
        }
    }
}

