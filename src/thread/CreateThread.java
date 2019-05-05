package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CreateThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThread1 thread1 = new CreateThread1();
        thread1.start();

        Runnable runnable = new CreateThread2();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        Callable callable = new CreateThread3();
        FutureTask<Object> futureTask = new FutureTask<>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();

        System.out.println("hello");

        System.out.println(futureTask.get());
        System.out.println("get success");
    }

    public static class CreateThread1 extends Thread {
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1");

        }
    }

    public static class CreateThread2 implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2");

        }
    }

    public static class CreateThread3 implements Callable {
        @Override
        public Object call() throws Exception {
            try {
                TimeUnit.MILLISECONDS.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "call return";
        }
    }

}
