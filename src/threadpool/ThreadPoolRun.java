package threadpool;

import java.util.concurrent.*;

public class ThreadPoolRun {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        threadPool.execute(() -> {
            System.out.println("11111");
        });


        threadPool.execute(() -> {
            System.out.println("22222");
        });

        threadPool.shutdown();
    }

}
