package sample_01;

/**
 * Created by N1kita on 11.01.2018.
 */
public class TheSimplestDeadLock {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }

}
