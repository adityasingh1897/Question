package customlock.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedOptimistic {
    int a = 10;
    StampedLock lock = new StampedLock();
    public void produce(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("optemistic read lock " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("no write happens " + Thread.currentThread().getName());
            }else{
                System.out.println("roll back " + Thread.currentThread().getName());
                a = 10;
            }
        }catch (InterruptedException e){

        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        try{
            System.out.println("write lock "  + Thread.currentThread().getName());
            a = 9;
        }
        finally {
lock.unlockWrite(stamp);
            System.out.println("write lock release " + Thread.currentThread().getName());
        }
    }
}
