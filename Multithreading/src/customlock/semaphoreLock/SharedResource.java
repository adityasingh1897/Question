package customlock.semaphoreLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    Semaphore lock = new Semaphore(2);
    public void produce()  {
        try {
        lock.acquire();
        System.out.println("lock aquired by :" + Thread.currentThread().getName());
        isAvailable = true;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.release();
            System.out.println("lock released by : " + Thread.currentThread().getName());
        }
    }
}

