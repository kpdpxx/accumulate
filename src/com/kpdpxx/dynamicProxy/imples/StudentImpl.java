package com.kpdpxx.dynamicProxy.imples;

import com.kpdpxx.dynamicProxy.intfs.SayIntf;

public class StudentImpl implements SayIntf {

	@Override
	public void sayHello() {
		System.out.println("您好我现在是一名学生");

	}

}
