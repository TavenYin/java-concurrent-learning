package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        System.out.println(executor);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            while (!Thread.interrupted())
                System.out.println("task");
        });
        Thread.sleep(1000);
        executor.shutdownNow();
    }

}
