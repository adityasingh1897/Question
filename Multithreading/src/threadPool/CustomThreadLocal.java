package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String > stringThreadLocal = new ThreadLocal<>();

        stringThreadLocal.set(Thread.currentThread().getName());

        Thread thread = new Thread(() ->{
            stringThreadLocal.set(Thread.currentThread().getName());
            System.out.println("data");
        });

        thread.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringThreadLocal.get());



        // cleaning the variable

        ExecutorService service = Executors.newFixedThreadPool(5);

        service.submit(() -> {
            stringThreadLocal.set(Thread.currentThread().getName());

//            stringThreadLocal.remove();
        });

        for (int i = 0; i < 15; i++) {
            service.submit(() ->
            {
                System.out.println(stringThreadLocal.get());
            });
        }
    }
}
