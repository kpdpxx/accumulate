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
		
		System.out.println("��ʼ");
		ExecutorService executorService=Executors.newCachedThreadPool();
		Future f=executorService.submit(new TCallable());
		
		if(f.isDone()){
			System.out.println("ִ�н���");
		}else{
			System.out.println("ִ���С�����δ����");
		}
//		System.out.println(f.get()); //ͬ���ȴ�ִ�н��
//		System.out.println("�첽�ύ����");
		/**
		 * û�м� get()����
		 * �첽�ύ����
			pool-1-thread-1 Callable  ����  ���ڴ�������������
			pool-1-thread-1 Callable  ����  ���ڴ�������������
			pool-1-thread-1 Callable  ����  ���ڴ�������������
			
			--------------
			�����get() ����
			pool-1-thread-1 Callable  ����  ���ڴ�������������
			pool-1-thread-1 Callable  ����  ���ڴ�������������
			pool-1-thread-1 Callable  ����  ���ڴ�������������
			 ������
			�첽�ύ����

		 */
		
	
		/*executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		} );*/
//		executorService.execute(new TRunnable());
		System.out.println("����");
		/**
		 * ��ʼ
			����
			pool-1-thread-1 Runnable  ����  ���ڴ�������������
			pool-1-thread-1 Runnable  ����  ���ڴ�������������
			pool-1-thread-1 Runnable  ����  ���ڴ�������������

		 */
	}
	public static  class TCallable implements Callable{
		static final int i=1;
		int ab=2;
		@Override
		public String call() throws Exception {
			for(int i=0;i<=2;i++){
				System.out.println(Thread.currentThread().getName()+" Callable  ����  ���ڴ�������������");
				Thread.currentThread().sleep(2000);
			}
			return " ������";
		}
		public static void test(){}
	}
	
public static	class TRunnable implements Runnable{
	static final int  sub_age=21;
		@Override
		public void run() {
			for(int i=0;i<=2;i++){
				System.out.println(Thread.currentThread().getName()+" Runnable  ����  ���ڴ�������������");
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


