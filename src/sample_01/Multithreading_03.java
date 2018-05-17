package sample_01;

/**
 * Created by N1kita on 11.01.2018.
 */
public class Multithreading_03 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String spaces = spaces(i);
            Runnable printer = new PrintRunnable(spaces + i, 100);

            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }

    //sure it is not optimal way to work with Strings, but it is just multithreading samples
    private static String spaces(int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}

class PrintRunnable implements Runnable{

    private String msg;
    private long sleepMillis;

    PrintRunnable(String msg, long sleepMillis){
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(msg);
        }
    }
}
