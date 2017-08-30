package com.kpdpxx.testEnum;

public enum PayStatus {
	CREATE(0,"创建","CREATE__remark"),
	PAYED(1,"已支付","已支付  备注备注备注备注备注"),
	CANCEL(2,"取消","取消 ——备注——备注——备注——备注");
	
	
private int a;
private String name;
private String remark;
	
PayStatus(int a,String remark,String name){
		this.a=a;
		this.name=name;
		this.remark=remark;
	};
	
	public static  String getPayStatusName(int a){
		String ret=null;
		for(PayStatus test:values()){
			if(a==test.a){
				ret=test.name;
			}
		}
		return ret;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
