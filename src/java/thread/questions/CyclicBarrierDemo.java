package thread.questions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //启动两个线程，分别执行完毕之后再执行主线程
        CyclicBarrier barrier  = new CyclicBarrier(2, () -> {
            //执行主线程
            System.out.println("主线程执行完毕");
 
        });
 
        //线程1执行
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
 
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
 
        //线程2执行
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
 
 
        thread1.start();
        thread2.start();
    }
}
