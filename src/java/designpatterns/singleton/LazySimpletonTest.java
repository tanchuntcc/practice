package designpatterns.singleton;

/**
 * @author 谭春
 * Date: 2020/5/26
 * Description:
 */
public class LazySimpletonTest implements Runnable {
    @Override
    public void run() {
        System.out.println(LazySimpleSingleton.getInstance());
    }

    public static void main(String[] args) {
        LazySimpletonTest t1 = new LazySimpletonTest();
        LazySimpletonTest t2 = new LazySimpletonTest();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.start();
        thread1.start();
    }
}

