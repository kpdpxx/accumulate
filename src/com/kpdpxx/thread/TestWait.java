package com.kpdpxx.thread;

public class TestWait {

	public static void main(String[] args) throws InterruptedException {
		Test1 test1=new Test1();
		/**
		 * Exception in thread "main" java.lang.IllegalMonitorStateException
		 */
		test1.wait();
		
	}

}

class Test1 implements Runnable{
	@Override
	public void run() {
		System.out.println("I am Test1!! testing wait method");
	}
}