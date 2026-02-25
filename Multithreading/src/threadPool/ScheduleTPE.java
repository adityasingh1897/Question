package threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTPE {
    public static void main(String[] args) {
        ScheduledExecutorService  executorService = Executors.newScheduledThreadPool(5);

        //schedule with runnable
        executorService.schedule(() ->{
            System.out.println("task done");
        }, 3, TimeUnit.SECONDS);

        //schedule with callable
        executorService.schedule(() ->{
            System.out.println("task done");
            return "done";
        }, 3, TimeUnit.SECONDS);

        //schedule at fixed rate
        Future<?> future = executorService.scheduleAtFixedRate(() ->{
            try{
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task done");
        }, 1, 3, TimeUnit.SECONDS);

        try{
            future.cancel(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //schedule at fixed delay
        future = executorService.scheduleWithFixedDelay(() ->{
            try{
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task done");
        }, 1, 3, TimeUnit.SECONDS);

        try{
            future.cancel(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
