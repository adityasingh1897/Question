package customlock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void produce(ReentrantLock lock){
        lock.lock();
        System.out.println("lock aquired by :" + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("lock released by : " + Thread.currentThread().getName());
        }
    }
}
