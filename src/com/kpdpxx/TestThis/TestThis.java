package com.kpdpxx.TestThis;

public class TestThis {

	private String name ;
	private String msg;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public TestThis() {
		// TODO Auto-generated constructor stub
	}
	public TestThis(String name) {
		this.name=name;
	}
	
	public TestThis(String ...strings ) {
		this.name=strings[0];
		//Constructor call must be the first statement in a constructor
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
