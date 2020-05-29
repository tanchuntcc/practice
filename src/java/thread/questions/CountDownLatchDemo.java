package thread.questions;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //启动两个线程，分别执行完毕之后再执行主线程
        CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(2);
 
        //线程1执行
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            countDownLatch.countDown();
        });
        //线程2执行
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            countDownLatch.countDown();
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            countDownLatch.countDown();
        });

        Thread thread4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            countDownLatch.countDown();
        });
 
 
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        //执行主线程
        System.out.println("主线程执行完毕");
    }
}