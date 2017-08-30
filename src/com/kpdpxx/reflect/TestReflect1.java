package com.kpdpxx.reflect;

import java.lang.reflect.Method;

public class TestReflect1 {

	public static void main(String[] args) throws Exception {
		
		Class stuClass=Class.forName("com.my.reflect.Student");
		Object o=stuClass.newInstance();
		
		//setName
		
		Method m=stuClass.getMethod("setName", java.lang.String.class);
		m.invoke(o, "reflect-set-testname");
		
		System.out.println(o);
	}

}
