package customlock.stampedLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable = false;

    StampedLock lock = new StampedLock();
     public void producer(){
         long stamp = lock.readLock();
         try {
             System.out.println("read lock acquired by " + Thread.currentThread().getName());
             Thread.sleep(1000);
         }catch (InterruptedException e ){

         }
         finally {
             lock.unlockRead(stamp);
             System.out.println("read lock release by " + Thread.currentThread().getName());
         }
     }

    public void consumer(){
        long stamp = lock.writeLock();
        try {
            System.out.println("write lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }catch (InterruptedException e ){

        }
        finally {
            lock.unlockWrite(stamp);
            System.out.println("write lock release by " + Thread.currentThread().getName());
        }
    }
}
