package com.kpdpxx.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.kpdpxx.dynamicProxy.imples.StudentImpl;
import com.kpdpxx.dynamicProxy.imples.TeacherImpl;
import com.kpdpxx.dynamicProxy.intfs.SayIntf;

public class TestDynamic {

	public static void main(String[] args) throws Throwable {
		InvocationHandler myInvocationHandler = new MyInvocationHandler();
		((MyInvocationHandler) myInvocationHandler).setTarget(new TeacherImpl());
		SayIntf proxy = (com.kpdpxx.dynamicProxy.intfs.SayIntf) Proxy.newProxyInstance(
				myInvocationHandler.getClass().getClassLoader(),
				StudentImpl.class.getInterfaces(), myInvocationHandler);

		proxy.sayHello();
	}

}
