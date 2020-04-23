package thread.questions;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 谭春
 * Date: 2020/3/31
 * Description:
 */
public class Question1 {
    public synchronized void s1(){
        System.out.println("同步方法1开始");

        try {
            Thread.sleep(5000);
            int i=5/0;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法1结束");
    }
    public synchronized void s2(){
        System.out.println("同步方法2开始");
        System.out.println("同步方法2结束");
    }
    public  void s3(){
        new LinkedList<>();
        new ArrayList<>();
        System.out.println("非同步方法2");
    }

    public static void main(String[] args) {
        Question1 c = new Question1();
        new Thread(()->{
            c.s1();
        }).start();

        new Thread(()->{
            c.s2();
        }).start();

        new Thread(()->{
            c.s3();
        }).start();
    }
}

