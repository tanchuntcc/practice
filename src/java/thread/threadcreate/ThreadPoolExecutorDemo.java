package thread.threadcreate;

import thread.threadcreate.ToExtendThread;
import thread.threadcreate.ToImpCallable;
import thread.threadcreate.ToImpRunable;

import java.util.concurrent.*;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程池参数分别是：核心线程数、最大线程池数、超过核心线程数的空闲存活时间、时间的单位、阻塞队列
        ExecutorService executor1=new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );
        //创建单核心的线程池
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        //创建一个按照定时计划规定执行的线程池
        ExecutorService executor3 = Executors.newScheduledThreadPool(4);
        //创建一个自动增长的线程池
        ExecutorService executor4 = Executors.newCachedThreadPool();
        //创建固定核心数的线程池
        ExecutorService executor5 = Executors.newFixedThreadPool(5);
        //创建一个具有抢占式操作的线程池
        ExecutorService executor6 = Executors.newWorkStealingPool();
        ToExtendThread thread = new ToExtendThread();
        ToImpRunable runable = new ToImpRunable();
        ToImpCallable callable = new ToImpCallable();
        //submit方法有返回值，execute方法没有
        executor1.execute(thread);
        executor1.execute(runable);
        Future<Integer> submit = executor1.submit(callable);
        Integer integer = submit.get();
        System.out.println(integer);
    }
}

