package com.kpdpxx.thread;
public class TestThreadJoin {
 
  public static void main(String[] args) {
   
    MyThread2 t1 = new MyThread2("TestJoin");
    t1.start();
    try {
      t1.join(1000);  //join()�ϲ��̣߳����߳�������֮�����̲߳ſ�ʼִ��
     }catch (InterruptedException e) {  }
      
     for(int i=0 ; i <10; i++)
              System.out.println("I am Main Thread");
   }
 }
 
 class MyThread2 extends Thread {
  
    MyThread2(String s) {
     super(s);
     }
     
  public void run() {
    for(int i = 1; i <= 10; i++) {
     System.out.println("I am "+getName());
     try {
      sleep(1000); //��ͣ��ÿһ�����һ��
      }catch (InterruptedException e) {
      return;
     }
     }
   }
  }