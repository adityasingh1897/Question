package threadPool;

import java.util.concurrent.*;

public class ThreadPoolExecutorMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactoryHandler(), new CustomRejectedExecutionHandler());

        executor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 14; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(6000);
                    System.out.println("Thread name  " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}

class CustomThreadFactoryHandler implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("aditya");
        t.setPriority(Thread.MAX_PRIORITY);
        return t;
    }
}


class CustomRejectedExecutionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(" task rejected " + r.toString());
    }
}
