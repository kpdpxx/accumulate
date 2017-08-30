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
				System.out.println("即将移除！移除前长度为："+list.size());
				list.remove(a);
				System.out.println("移除成功！移除后的长度为："+list.size());
			}
		}

		for(String a:list){
			if(a.endsWith("t2")){
				System.out.println("即将添加！添加前长度为："+list.size());
				list.add("dsfsd");
				System.out.println("添加成功！添加后的长度为："+list.size());
			}
		}
		Iterator<String> iterator =list.iterator();
		while(iterator.hasNext()){
			String arg=iterator.next();
			if(arg.endsWith("t2")){
				iterator.remove();
			}

			
		}
		
		System.out.println("处理结束");
	}

}
