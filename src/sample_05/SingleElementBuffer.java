package sample_05;

import java.util.concurrent.TimeoutException;

/**
 * @author Mykyta Shvets
 * @since 2018-01-18.
 */
public class SingleElementBuffer<T> {
    private T elem = null;

    public synchronized void put(T newElem, long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (this.elem != null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            this.wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }
        if (waitTime <= 0 && this.elem != null) {
            throw new TimeoutException();
        }
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized T get(long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (this.elem == null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            this.wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }
        if (waitTime <= 0 && this.elem == null) {
            throw new TimeoutException();
        }
        T result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
