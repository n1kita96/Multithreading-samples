package sample_02;

/**
 * Created by N1kita on 16.01.2018.
 */
public class ProducerConsumerExample2 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1,330,buffer)).start();
        new Thread(new Producer(100,500,buffer)).start();
        new Thread(new Producer(1000,700,buffer)).start();

        new Thread(new Consumer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
