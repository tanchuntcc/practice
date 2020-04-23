package thread.questions;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 谭春
 * Date: 2020/3/31
 * Description:
 */
public class Question2 {
    static Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public void s1() throws InterruptedException {
        System.out.println("同步方法1开始");
        lock1.lock();
        Thread.sleep(1000);
        lock2.lock();
        lock1.unlock();
        lock2.unlock();
        System.out.println("同步方法1结束");
    }

    public void s2() throws InterruptedException {
        System.out.println("同步方法2开始");
        lock2.lock();
        Thread.sleep(1000);
        lock1.lock();
        lock2.unlock();
        lock1.unlock();
        System.out.println("同步方法2结束");
    }

    public static void main(String[] args) {

        Question2 c = new Question2();
        new Thread(() -> {
            try {
                c.s1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                c.s2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

