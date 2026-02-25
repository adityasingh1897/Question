package threadPool;

import java.util.concurrent.*;

public class CallableCustom {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.HOURS, new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    Future<?> future1 = executor.submit(() -> {
        System.out.println("do nothing");   // it's not returning anything so, submit is calling runnable one
    });

    Future<Integer> future2 = executor.submit(() -> {
        System.out.println("do nothing");
        return 6;  //returning so, submit calling callable
    });
}
