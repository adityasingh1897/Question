package threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        //1st way of submit(runable)
        Future<?> future1 = executor.submit(() -> {
            System.out.println("task done");
        });

        try {
            System.out.println(future1.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        //2nd way of submit(runnable, T)
        List<Integer> list = new ArrayList<>();

        Future<List<Integer>> future = executor.submit(new MyRunnable(list), list);

        try {
            future.get();
            //1st way
            System.out.println(list.get(0));

            //2nd way if no acccess to list
            List<Integer> result = future.get();
            System.out.println(result.get(0));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        //3rd way of submit(callable)

        Future<Integer> future2 = executor.submit(() ->{
            //do something
            return 100;
        });

        try {
            System.out.println(future2.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
