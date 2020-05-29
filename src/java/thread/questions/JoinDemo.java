package thread.questions;

/**
 * @author 谭春
 * Date: 2020/5/26
 * Description:
 */
public class JoinDemo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+Thread.currentThread().getName()+": "+i);
        }
    }

    public static void main(String[] args) {
        JoinDemo c1 = new JoinDemo();
        JoinDemo c2 = new JoinDemo();
        JoinDemo c3 = new JoinDemo();

        try {
            c1.start();
            c1.join();
            c2.start();
            c2.join();
            c3.start();


            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

