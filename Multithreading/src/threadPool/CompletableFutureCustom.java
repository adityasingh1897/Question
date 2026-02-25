package threadPool;

import java.util.concurrent.*;

public class CompletableFutureCustom {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.HOURS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //supplyAsync
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            return "task completed";
        }, executor);

        try {
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        //ThenApply and ThenApplyAsync

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            return "task completed";
        }, executor).thenApply((String val) -> { //function which are working on the return value of previous async
            return val + " by thread";
        });


        try {
            System.out.println(future1.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        //thenApply

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return "task completed";
        }, executor);

        future2.thenApply((String val) -> { //function which are working on the return value of previous async
            System.out.println(" name " + Thread.currentThread().getName());
            return val + " by thread";
        });


        //thenApplyAsync
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return "task completed";
        }, executor);

        future3.thenApplyAsync((String val) -> { //function which are working on the return value of previous async
                    System.out.println(" name " + Thread.currentThread().getName());
                    return val + " by thread";
                });
//        }, executor);


        //thenCompose & thenCOmposeAsync

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return "task completed";
        }, executor);

        future4.thenCompose((String val) -> { //function which are working on the return value of previous async
            System.out.println(" name " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> val + "name") ;
        });

        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return "task completed";
        }, executor);

        future5.thenComposeAsync((String val) -> { //function which are working on the return value of previous async
            System.out.println(" name " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> val + "name") ;
        });
        //}, executor);


        //thenAccept and thenAcceptAsync

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return "task completed";
        }, executor).thenAccept((String val) -> { //function which are working on the return value of previous async
            System.out.println(" name " + Thread.currentThread().getName());
        });


        //thenCombine and thenCombineAsync
        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return 10;
        }, executor);

        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> {
            //task need to be completed by thread
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" name " + Thread.currentThread().getName());
            return "data";
        }, executor);

        CompletableFuture<String > ans = future7.thenCombine(future8, (Integer i, String val) -> i + val);

    }
}
