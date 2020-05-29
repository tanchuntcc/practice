package thread.threadcreate;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:
 */
public class ToImpRunable implements Runnable{
    //覆盖run方法
    @Override
    public void run() {
        System.out.println("通过实现Runnable方法:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ToImpRunable runnable = new ToImpRunable();
        //创建线程对象
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        //启动线程
        thread1.start();
        thread2.start();

        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

            strs.transfer("aaa");

//            strs.put("aaa");
//
//
//            new Thread(() -> {
//                try {
//                    System.out.println(strs.take());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
        }
    }

