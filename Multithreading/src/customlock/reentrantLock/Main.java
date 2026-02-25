package customlock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ReentrantLock lock = new ReentrantLock(); // resource
        SharedResource sharedResource1 = new SharedResource();

//        Thread t1 = new Thread( () -> sharedResource.produce(lock));
//        Thread t2 = new Thread( () -> sharedResource.produce(lock));


//        Thread t1 = new Thread( () -> sharedResource.produce(lock));
//        Thread t2 = new Thread( () -> sharedResource1.produce(lock));


        //now both can access
        Thread t1 = new Thread( () -> sharedResource.produce(new ReentrantLock()));
        Thread t2 = new Thread( () -> sharedResource.produce(new ReentrantLock()));

        t1.start();
        t2.start();
    }
}
