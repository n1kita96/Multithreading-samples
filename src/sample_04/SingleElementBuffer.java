package sample_04;

/**
 * Created by N1kita on 17.01.2018.
 * Try to optimize
 * 'if' and '++' and '--' and 'notify()' faster than 'notifyAll()'
 */

public class SingleElementBuffer<T> {
    private T elem = null;
    private int waitedProducers = 0;
    private int waitedConsumers = 0;

    public synchronized void put(T newElem) throws InterruptedException {
        while (this.elem != null) {
            waitedProducers++;
            this.wait();
            waitedProducers--;
        }
        this.elem = newElem;
        if (waitedConsumers > 0) {
            this.notify();
        }
    }

    public synchronized T get() throws InterruptedException {
        while (this.elem == null) {
            waitedConsumers++;
            this.wait();
            waitedConsumers--;
        }
        T result = this.elem;
        this.elem = null;
        if (waitedProducers > 0) {
            this.notify();
        }
        return result;
    }
}
