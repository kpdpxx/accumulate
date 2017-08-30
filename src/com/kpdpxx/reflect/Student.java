package com.kpdpxx.reflect;

public class Student {
	private String age;
	private String name;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("age=").append(getAge()).append("|name=").append(getName());
		return sb.toString();
	}
}
