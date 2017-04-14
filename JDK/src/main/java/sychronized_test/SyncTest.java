package sychronized_test;

import java.util.concurrent.CountDownLatch;

public class SyncTest {
	//
	
	public static volatile Integer i=0;
	static CountDownLatch count = new CountDownLatch(1000);
	
	public static  void inc(){
		synchronized(i){
			
		}
		try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
		i++;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					SyncTest.inc();
					SyncTest.count.countDown();
				}
			}).start();;
		}
		
		try {
			//用来保证i的值是在所有线程执行完成后的最终值
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(i);
	}
}
