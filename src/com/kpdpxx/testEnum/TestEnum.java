package com.kpdpxx.testEnum;

public class TestEnum {

	public static void main(String[] args) {
		System.out.println("≤‚ ‘√∂æŸ÷µ");
		
		int a=1;
		System.out.println(PayStatus.getPayStatusName(a));
		
		PayStatus.CREATE.name();
		System.out.println(PayStatus.CREATE.getName());
		System.out.println(PayStatus.CANCEL.getRemark());
	}

}
