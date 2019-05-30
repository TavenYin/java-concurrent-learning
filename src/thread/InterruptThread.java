package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(5);
        Thread t = new Thread(() -> {
            for (int i=0; i<1000000; i++)
                System.out.println("我在做事");

            System.out.println("我做完了");

            try {
//                queue.take();
                queue.poll(1, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        t.interrupt();

    }

    private static void test1() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(5);
        Thread t = new Thread(() -> {
            try {
//                queue.take();
                queue.poll(1, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }

}
