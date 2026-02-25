package customlock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock) {
        try{
            lock.readLock().lock();
            System.out.println("read lock acquire by : " + Thread.currentThread().getName());
            Thread.sleep(10000);
        }catch (InterruptedException w){

        }
        finally {
            lock.readLock().unlock();
            System.out.println("read lock released by " + Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("write lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
        }catch (Exception e){

        }
        finally {
            lock.writeLock().unlock();
            System.out.println("write lock released by " + Thread.currentThread().getName());
        }
    }
}
