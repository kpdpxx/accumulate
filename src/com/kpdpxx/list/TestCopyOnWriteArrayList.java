package com.kpdpxx.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list =new CopyOnWriteArrayList();
		for(int i=0;i<5;i++){
			list.add("test"+i);
		}
		
		for(String a:list){
			if(a.endsWith("t1")){
				System.out.println("�����Ƴ����Ƴ�ǰ����Ϊ��"+list.size());
				list.remove(a);
				System.out.println("�Ƴ��ɹ����Ƴ���ĳ���Ϊ��"+list.size());
			}
		}

		for(String a:list){
			if(a.endsWith("t2")){
				System.out.println("������ӣ����ǰ����Ϊ��"+list.size());
				list.add("dsfsd");
				System.out.println("��ӳɹ�����Ӻ�ĳ���Ϊ��"+list.size());
			}
		}
		Iterator<String> iterator =list.iterator();
		while(iterator.hasNext()){
			String arg=iterator.next();
			if(arg.endsWith("t2")){
				iterator.remove();
			}

			
		}
		
		System.out.println("�������");
	}

}
