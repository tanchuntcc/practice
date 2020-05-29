package thread.questions;

/**
 * @author 谭春
 * Date: 2020/5/15
 * Description:
 */
public class Question3 {
    int x=0;
    public class Runner implements Runnable{
        @Override
        public void run() {
            int current=0;
            for (int i = 0; i < 4; i++) {
                current = x;
                System.out.println(current+",");
                x=current+2;
            }
        }
    }

    public void go(){
        Runnable r1 = new Runner();
        new Thread(r1).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1).start();

    }
    public static void main(String[] args) {
        new Question3().go();
    }


}

