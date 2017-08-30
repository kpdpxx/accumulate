package com.kpdpxx.testinnerClass;
/**
 * 
 *
 */
public class TestOutClass {
	private String name="TestOutClass_name";
	private String addr="TestOutClass_add";
	private static String salary="TestOutClass_salary";
	private static final  String identity_card="TestOutClass_salary";
	
	public static void main(String[] args)throws Exception{

		TestOutClass testOutClass=new TestOutClass();
		InnerClass1 innerClass1=testOutClass.new InnerClass1();
		/**
		 * The final field TestOutClass.identity_card cannot be assigned
		 */
//		identity_card="asd";
		
		innerClass1.showName();
		innerClass1.showSal();
		innerClass1.showOtherNam();
		
		/**
		 * 静态类不需要依赖外部类来实例化
		 */
		InnerClass2 innerClass2=new InnerClass2();
		
		
	}
	
	public class InnerClass1{
		/**
		 * The field name cannot be declared static in a non-static inner type, unless initialized with a constant expression
		 */
		//static String name1="static_name";
		
		static final String name1="InnerClass1 other name";
		/**
		 * 内部类中的变量名和外部变量名一致则使用内部类的变量
		 */
		String name="static_name_1";
		
		String in_salary="in_salary" +salary;
		
		public void showName(){
			System.out.println("InnerClass1 name="+name);
		}
		
		public void showSal(){
			System.out.println("InnerClass1  salary="+salary);
		}
		
		public void showOtherNam(){
			System.out.println(name1);
		}
		
	}
	public InnerClass1 getInnerClass1(){
		return new InnerClass1();
	}
	
	public InnerClass2 getInnerClass2(){
		return new InnerClass2();
	}
	public static class InnerClass2{
		private String daughter_name="lily";
		
		private static String  son_name="john";
		
		private final String other_msg="to be continue..";
		
		public void showName (){
			/**
			 * Cannot make a static reference to the non-static field name
			 */
			//System.out.println(name);
		}
		
		public void showSal(){
			System.out.println(salary);
		}
	}
}
