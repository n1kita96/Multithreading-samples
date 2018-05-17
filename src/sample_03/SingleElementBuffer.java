package sample_03;

/**
 * @author Mykyta Shvets
 * @since 17.01.2018.
 */
public class SingleElementBuffer<T> {
    private T elem = null;

    public synchronized void put(T newElem) throws InterruptedException {
        while (this.elem != null){
            this.wait();
        }
        this.elem = newElem;
        this.notifyAll();
    }

     public synchronized T get() throws InterruptedException {
        while (this.elem == null){
            this.wait();
        }
        T result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
     }
}
