package com.kpdpxx.testConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSubmint {
	private int p_age=12;
	private static int s_p_age=13;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		new Thread( new Runnable() {
			public void run() {
				
			}
		});
		
		System.out.println("开始");
		ExecutorService executorService=Executors.newCachedThreadPool();
		Future f=executorService.submit(new TCallable());
		
		if(f.isDone()){
			System.out.println("执行结束");
		}else{
			System.out.println("执行中。。。未结束");
		}
//		System.out.println(f.get()); //同步等待执行结果
//		System.out.println("异步提交结束");
		/**
		 * 没有加 get()方法
		 * 异步提交结束
			pool-1-thread-1 Callable  方法  正在处理。。。。。。
			pool-1-thread-1 Callable  方法  正在处理。。。。。。
			pool-1-thread-1 Callable  方法  正在处理。。。。。。
			
			--------------
			添加了get() 方法
			pool-1-thread-1 Callable  方法  正在处理。。。。。。
			pool-1-thread-1 Callable  方法  正在处理。。。。。。
			pool-1-thread-1 Callable  方法  正在处理。。。。。。
			 结束了
			异步提交结束

		 */
		
	
		/*executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		} );*/
//		executorService.execute(new TRunnable());
		System.out.println("结束");
		/**
		 * 开始
			结束
			pool-1-thread-1 Runnable  方法  正在处理。。。。。。
			pool-1-thread-1 Runnable  方法  正在处理。。。。。。
			pool-1-thread-1 Runnable  方法  正在处理。。。。。。

		 */
	}
	public static  class TCallable implements Callable{
		static final int i=1;
		int ab=2;
		@Override
		public String call() throws Exception {
			for(int i=0;i<=2;i++){
				System.out.println(Thread.currentThread().getName()+" Callable  方法  正在处理。。。。。。");
				Thread.currentThread().sleep(2000);
			}
			return " 结束了";
		}
		public static void test(){}
	}
	
public static	class TRunnable implements Runnable{
	static final int  sub_age=21;
		@Override
		public void run() {
			for(int i=0;i<=2;i++){
				System.out.println(Thread.currentThread().getName()+" Runnable  方法  正在处理。。。。。。");
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}


