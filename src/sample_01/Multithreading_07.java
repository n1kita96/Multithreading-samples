package sample_01;

/**
 * Created by N1kita on 12.01.2018.
 */
public class Multithreading_07 {
    public static void main(String[] args) throws InterruptedException {
//        new Object().wait(); //java.lang.IllegalMonitorStateException
//        new Object().notify(); //java.lang.IllegalMonitorStateException
//        new Object().notifyAll(); //java.lang.IllegalMonitorStateException

        Object object = new Object();
        synchronized (object){
            object.wait(1000); //no exceptions, program waits; the same with notify(), notifyAll()
        }

        notifyTest(); //java.lang.IllegalMonitorStateException
    }

    public static synchronized void notifyTest(){
        new Object().notify();
    }
}
