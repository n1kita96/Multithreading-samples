package sample_01;

/**
 * Created by N1kita on 12.01.2018.
 */
public class Multithreading_09 {
    public static void main(String[] args) {
        synchronized (Multithreading_09.class){
            Multithreading_09.class.notify(); //no exceptions
        }
    }
}
