package thread.threadcreate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:
 */
public class ToImpCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("通过实现Callable创建线程");
        int i=1;
        return i;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建callable对象
        ToImpCallable callable = new ToImpCallable();
        //通过FutureTask封装FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //创建线程对象
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = null;
        //通过FutureTask的get方法获取call方法中的返回值
        integer = futureTask.get();
        System.out.println(integer);
    }
}

