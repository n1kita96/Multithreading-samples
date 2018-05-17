package sample_02;

/**
 * Created by N1kita on 12.01.2018.
 * Easy to write using generics here,
 * but main point is monitor conception.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null){
            this.wait();
        }
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null){
            this.wait();
        }
        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
