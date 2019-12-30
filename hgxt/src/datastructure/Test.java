package datastructure;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        String str = "ab";
        System.out.println(str.hashCode());
        str = "ac";
        System.out.println(str.hashCode());
//        Test test = new Test();
//        Thread th1 = new Thread(test.new runs(String.valueOf(1)));
//        th1.start();
//        Thread.sleep(2*1000);
//        if(th1.isAlive()){
//            System.out.println("alive");
//            th1.interrupt();
//        } else {
//            System.out.println("dead");
//        }
//        System.out.println("ok");
    }
    class runs implements Runnable{
        private String threadname;
        public runs(String threadname){
            this.threadname=threadname;
        }
        @Override
        public void run() {
            System.out.println("threadname "+threadname+" begin");
            try {
                Thread.sleep(3*1000);
                if(Thread.interrupted()){
                    System.out.println("threadname interrupt");
                }
                System.out.println("threadname "+threadname+" execute");
            } catch (Exception e) {
                System.out.println("th1 error:"+e.getMessage());
            }
            System.out.println("threadname"+threadname+" end");
        }
    }

}

