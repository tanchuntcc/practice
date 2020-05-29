package thread.questions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock();

    public void test() {
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + " 尝试获取锁");
            lock.lockInterruptibly();
            Thread.sleep(1000);
            System.out.println(name + " 得到锁");
        } catch (InterruptedException e) {
            System.out.println(name + " InterruptedException异常");
        } finally {
            try {
                lock.unlock();
                System.out.println(name + " 尝试释放锁");
            } catch (Exception e) {
                System.out.println(name + " : 释放锁失败（未获取锁的线程调用unlock）");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo lock = new ReentrantLockDemo();
        Thread t0 = new Thread(
                lock::test
        );
        Thread t1 = new Thread(
                lock::test
        );
        t0.start();
        Thread.sleep(10);
        t1.start();
        Thread.sleep(100);
        // 中断等待中的t1的线程
        t1.interrupt();
    }
}