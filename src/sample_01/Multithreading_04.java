package sample_01;

/**
 * Created by N1kita on 12.01.2018.
 *
 * Combinatorial explosion example
 */
public class Multithreading_04 {
    public static void main(String[] args) {
        Thread thread = new Thread(new BunnyRunnable(1));
        thread.start();
    }
}

class BunnyRunnable implements Runnable{
    private int count;

    public BunnyRunnable(int count){
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(count);
            Thread thread = new Thread(new BunnyRunnable(count++));
            thread.start();
        }
    }
}