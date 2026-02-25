public class MonitorLock {
    public synchronized void task1(){
        try {
            System.out.println("inside task 1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("task2 before synchronized");
        synchronized (this){
            System.out.println("task 2 after synchronized");
        }
    }

    public void task3(){
        System.out.println("task 3");
    }

    public static void main(String[] args) {
        MonitorLock monitorLock = new MonitorLock();
//        Thread t1 = new Thread(monitorLock::task1);
//        Thread t2 = new Thread(monitorLock::task2);
//        Thread t3 = new Thread(monitorLock::task3);
//
//        t1.start();
//        t2.start();
//        t3.start();
        Thread t1 = new Thread(monitorLock::produce);
        MonitorLock monitorLock1 = new MonitorLock();
        Thread t2 = new Thread(monitorLock1::produce);
        t1.start();
        t2.start();
    }

    public synchronized void produce(){
        try {
            System.out.println("before sleep " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("after sleep" + Thread.currentThread().getName());
    }
}
