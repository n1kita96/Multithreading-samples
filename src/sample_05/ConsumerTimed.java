package sample_05;

import java.util.concurrent.TimeoutException;

/**
 * @author Mykyta Shvets
 * @since 2018-01-18.
 */
public class ConsumerTimed<T> implements Runnable {
    private final SingleElementBuffer<T> buffer;
    private final long timeout;

    public ConsumerTimed(SingleElementBuffer<T> buffer, long timeout) {
        this.buffer = buffer;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            T elem = null;
            try {
                elem = buffer.get(timeout);
                System.out.println(elem + " consumed");

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped");
                return;
            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + " time out");
                return;
            }
        }
    }
}
