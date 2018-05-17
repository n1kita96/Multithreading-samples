package sample_02;

/**
 * Created by N1kita on 13.01.2018.
 */
public class ProduserConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1,1000, buffer)).start();
        Thread.sleep(5000);
        new Thread(new Consumer(buffer)).start();
    }
}
