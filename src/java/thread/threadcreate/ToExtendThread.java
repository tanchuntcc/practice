package thread.threadcreate;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:
 */
public class ToExtendThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+"-----"+i);
            if (i==5){
                yield();
            }
        }
        System.out.println("通过继承Thread类:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        //创建线程对象
        ToExtendThread thread1 = new ToExtendThread();
        ToExtendThread thread2 = new ToExtendThread();
        thread2.setPriority(10);
        int priority1 = thread1.getPriority();
        int priority2 = thread2.getPriority();

        System.out.println("优先级1："+priority1);
        System.out.println(thread1.getName());
        System.out.println("优先级2："+priority2);
        //启动线程
        thread1.start();
        thread2.start();
    }
}

