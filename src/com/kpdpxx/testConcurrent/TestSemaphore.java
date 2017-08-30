package com.kpdpxx.testConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
	public static void main(String[] args) {

        // �̳߳�

        ExecutorService exec = Executors.newCachedThreadPool();

        // ֻ��5���߳�ͬʱ����

        final Semaphore semp = new Semaphore(2,false);

         // ģ��20���ͻ��˷���

         for (int index = 0; index < 20; index++) {

                      final int NO = index;

                      Runnable run = new Runnable() {

                                         public void run() {

                                                    try {

                                                            // ��ȡ���

                                                            semp.acquire();

                                                            System.out.println("Accessing: " + NO);
                                                            Thread.currentThread().setName("Thread"+NO);

//                                                            Thread.sleep((long) (Math.random() * 10000));
                                                            Thread.sleep((long) (1000));

                                                            // ��������ͷ�

                                                            semp.release();

                                                            System.out.println(Thread.currentThread().getName()+" end >>availablePermits:"+semp.availablePermits());

                                                    } catch (InterruptedException e) {

                                                            e.printStackTrace();

                                                    }

                                          }

                              };

              exec.execute(run);

     }

     // �˳��̳߳�

     exec.shutdown();

}
}
