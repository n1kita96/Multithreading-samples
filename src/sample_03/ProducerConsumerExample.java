package sample_03;

/**
 * @author Mykyta Shvets
 * @since 17.01.2018.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBuffer<String> buffer = new SingleElementBuffer<>();

        new Thread(new Producer<>("elem", 1000, buffer)).start();
        new Thread(new Producer<>("elem2", 1500, buffer)).start();

        Thread.sleep(5000);

        new Thread(new Consumer<>(buffer)).start();
    }
}
