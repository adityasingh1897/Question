package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Custom {

    public static void main(String[] args) throws InterruptedException {
        //task submission after shutdown

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(() -> {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task submitted");
        });

        service.shutdown();

        boolean terminated = service.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println(terminated);

        service.shutdownNow();
//        service.submit(() -> {
//            System.out.println("task submitted after shutdwon");
//        });
    }
}
