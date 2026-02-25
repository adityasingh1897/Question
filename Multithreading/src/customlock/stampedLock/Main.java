package customlock.stampedLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(sharedResource::producer);
        Thread t2 = new Thread(sharedResource::producer);
        Thread t3 = new Thread(sharedResource::consumer);

//
//        t1.start();
//        t2.start();
//        t3.start();

        SharedOptimistic sharedOptimistic = new SharedOptimistic();

        Thread t4 = new Thread(sharedOptimistic::produce);
        Thread t5 = new Thread(sharedOptimistic::consumer);

        t4.start();
        t5.start();
    }
}
