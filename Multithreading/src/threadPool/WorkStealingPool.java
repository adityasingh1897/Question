package threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class WorkStealingPool {
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();//
//        ForkJoinPool forkJoinPool1 = (ForkJoinPool) Executors.newWorkStealingPool();
        Future<Integer> future = forkJoinPool.submit(new ComputeTask(0,100));

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ComputeTask extends RecursiveTask<Integer> {

    int start, end;

    ComputeTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-start < 4){
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            int mid = (end-start)/2;
            //spit the task
            ComputeTask leftTask = new ComputeTask(start, mid);
            ComputeTask rightTask = new ComputeTask(mid+1, end);

            //fork the sub task for parallel execution

            leftTask.fork();
            rightTask.fork();

            //combine the result of subtask

            int left = leftTask.join();
            int right = rightTask.join();

            return  left+right;
        }
    }
}
