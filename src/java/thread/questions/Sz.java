package thread.questions;

/**
 * @author 谭春
 * Date: 2020/4/10
 * Description:
 */
public class Sz {

        static Object lock1 = new Object();
        static Object lock2 = new Object();
        public static   void method(){
            synchronized(lock1) {
                System.out.println(lock1.hashCode());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //需要调用 lock.notify();
            }
        }

    public static  void method2(){
        System.out.println(lock2.hashCode());
    }

    public static void main(String[] args) {
        method();
        method2();
    }
}

