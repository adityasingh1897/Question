public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(i);
//            }
//        });
//        t.start();
////        t.join();
//        for (int i = 6; i < 10; i++) {
//            System.out.println(i);
//        }




//        Deamon Thread

//        Thread t2 = new Thread(() ->{while (true){
//            System.out.println("daemon");
//        }});
//        t2.setDaemon(true);
//        t2.start();
//        System.out.println("main end");



        //priority thread

        Thread t1 = new Thread(()-> System.out.println("min priority"));
        Thread t2 = new Thread(()-> System.out.println("Max priority"));

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        t1.start();

    }
}
