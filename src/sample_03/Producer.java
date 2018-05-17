package sample_03;

/**
 * @author Mykyta Shvets
 * @since 17.01.2018.
 */
public class Producer<T> implements Runnable{
    private T elem;
    private final int period;
    private final SingleElementBuffer<T> buffer;

    public Producer(T elem, int period, SingleElementBuffer<T> buffer) {
        this.elem = elem;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(this.elem + " produced");
                buffer.put(this.elem);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped");
                break;
            }
        }
    }
}
