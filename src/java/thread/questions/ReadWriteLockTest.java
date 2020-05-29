package thread.questions;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockTest {

	private double data = 0;
	
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public void get(){
		try {
			rwl.readLock().lock();
			System.out.println("----Thread:"+Thread.currentThread().getName()+"----read first value:"+data);
			Thread.sleep(1000);
			System.out.println("----Thread:"+Thread.currentThread().getName()+"----read second value:"+data);
			rwl.readLock().unlock();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void put(){
		try {
			rwl.writeLock().lock();
			data = Math.random();
			System.out.println("----Thread:"+Thread.currentThread().getName()+"----write first value:"+data);
			Thread.sleep(100);
            System.out.println("----Thread:"+Thread.currentThread().getName()+"----write end value:"+data);
            rwl.writeLock().unlock();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
