import java.util.concurrent.locks.ReentrantLock;

public class MyFairLock extends Thread{

    private ReentrantLock lock = new ReentrantLock(false);
    public void fairLock(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()  + "正在持有锁");
        }finally {
            System.out.println(Thread.currentThread().getName()  + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
//        final MyFairLock myFairLock = new MyFairLock();
//        Runnable runnable = new Runnable(){
//            @Override
//            public void run(){
//                System.out.println(Thread.currentThread().getName() + "启动");
//                myFairLock.fairLock();
//            }
//        };
//        Thread[] thread = new Thread[10];
//        for(int i = 0;i < 10;i++){
//            thread[i] = new Thread(runnable);
//        }
//        for(int i = 0;i < 10;i++){
//            thread[i].start();
//        }
        String str = "我是华刚，hello";
        System.out.println(System.getProperty("file.encoding"));
        byte[] bytes = str.getBytes("GBK");
        System.out.println(new String(bytes));
        System.out.println(new String(bytes, "GBK"));
    }
}