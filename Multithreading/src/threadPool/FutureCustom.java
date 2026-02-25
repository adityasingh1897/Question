package threadPool;

import java.util.concurrent.*;

public class FutureCustom {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.HOURS,new
                ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("This is the task which thread will execute : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("caller thread is checking if it's done " + future.isDone() );

        try {
            future.get(2, TimeUnit.SECONDS);
        }catch (TimeoutException | InterruptedException | ExecutionException e){
            System.out.println("timed out happened");
        }

        System.out.println("caller thread (main) will wait to finish thread");
        try {
            future.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main wait finish");
        System.out.println("is done "+future.isDone());
        System.out.println("is cancelled " + future.isCancelled());
    }
}
