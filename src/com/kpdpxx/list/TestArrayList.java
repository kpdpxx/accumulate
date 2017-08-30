package com.kpdpxx.list;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {

	public static void main(String[] args){
		ArrayList<String> list =new ArrayList();
		for(int i=0;i<5;i++){
			list.add("test"+i);
		}
		
		/**
		 * Exception in thread "main" java.util.ConcurrentModificationException

		 */
		/*for(String a:list){
			if(a.endsWith("t1")){
				list.remove(a);
			}
		}*/
		/**
		 * Exception in thread "main" java.util.ConcurrentModificationException

		 */
		for(String a:list){
			if(a.endsWith("t1")){
				list.add("dsfsd");
			}
		}
		
		/*Iterator<String> iterators=list.iterator();
		;
		while(){
			iterators.hasNext()
		}*/
		System.out.println("½áÊø");
	}
}
