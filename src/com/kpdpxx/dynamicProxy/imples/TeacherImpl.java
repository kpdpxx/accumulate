package com.kpdpxx.dynamicProxy.imples;

import com.kpdpxx.dynamicProxy.intfs.SayIntf;

public class TeacherImpl implements SayIntf {

	@Override
	public void sayHello() {
		System.out.println("您好我是的职业是【老师】");

	}

}
