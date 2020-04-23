package test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 谭春
 * Date: 2020/4/6
 * Description:
 */
public class Ac {

    // 同时并发执行的线程数
    public static final int threadTotal = 200;

    public Integer create(int start,int end) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(end-start);
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = start; i <= end; i++) {
            final int num = i;
            System.out.println("**************" + Thread.currentThread().getName() + "; num " + num);
            executorService.execute(() -> {
                String string= "EVENT" + num;
                list.add(string);
                if (num % 1000 == 0) {
                    try {
                        semaphore.acquire();
                        System.out.println(list.toString());
                        semaphore.release();
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        list.clear();
                        countDownLatch.countDown();
                    }
                }
            });

        }
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println("---------------主线程启动失败-----------------");
        }
        return 1;
    }

    public static void main(String[] args) {
        Ac ac = new Ac();
        Integer integer = ac.create(0, 10000);
        System.out.println(integer);
    }
}

