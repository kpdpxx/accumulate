package com.kpdpxx.testConcurrent;

import java.util.concurrent.atomic.AtomicLong;

public class TestAtomicLong {

	static AtomicLong along =new AtomicLong();
	volatile	String as ="d";
	public volatile	int int_a =12;

	public static void main(String[] args){
		
	
		along.compareAndSet(4, 2);
		System.out.println(along);

		along.getAndAdd(2);
		System.out.println(along);

	}
}
