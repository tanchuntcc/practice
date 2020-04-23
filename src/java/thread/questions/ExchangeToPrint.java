package thread.questions;

/**
 * @author 谭春
 * Date: 2020/4/14
 * Description:AB线程交替打印1到100的数
 */
public class ExchangeToPrint {
    volatile static int i=1;

    public static void main(String[] args) {
        ExchangeToPrint obj = new ExchangeToPrint();

        Runnable runnable = () -> {
            while (i<101){
                synchronized (obj){
                    obj.notify();
                    System.out.println(Thread.currentThread().getName()+"-----"+i++);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

    }

}

