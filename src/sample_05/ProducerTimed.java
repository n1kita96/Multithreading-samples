package sample_05;

import java.util.concurrent.TimeoutException;

/**
 * @author Mykyta Shvets
 * @since 2018-01-18.
 */
public class ProducerTimed<T> implements Runnable {
    private T elem;
    private final int period;
    private final SingleElementBuffer<T> buffer;
    private final long timeout;

    public ProducerTimed(T elem, int period, SingleElementBuffer<T> buffer, long timeout) {
        this.elem = elem;
        this.period = period;
        this.buffer = buffer;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this.elem + " produced");
            try {
                buffer.put(this.elem, this.timeout);
                Thread.sleep(period);
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
