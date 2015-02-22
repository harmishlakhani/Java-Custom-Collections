package com.application;

import com.java.collection.CustomArrayList;
import com.java.collection.CustomLinkedList;
import com.java.collection.CustomList;

public class CustomLinkedListClient {

	public static void main(String[] args) {
		
		//Strings
		CustomList<String> customList = new CustomLinkedList<String>();
		System.out.println("List is empty : " + customList.isEmpty());
		
		customList.add("Prashant");
		customList.add("Akbari");
		
		System.out.println("List size : " + customList.size());
		System.out.println("List element 1 : " + customList.get(0));
		System.out.println("List element 2 : " + customList.get(1));
		//System.out.println("List element 8 : " + customList.get(8));
		
		//Integer
		CustomList<Integer> customListInts = new CustomArrayList<Integer>();
		System.out.println("List is empty : " + customListInts.isEmpty());
		
		for(int i = 0; i < 10; i++) {
			customListInts.add(i);
		}
		
		System.out.println("List size : " + customListInts.size());
		
		System.out.println(customListInts.get(1));
		customListInts.remove(1);
		System.out.println(customListInts.get(1));
		System.out.println(customListInts.get(0));
		System.out.println(customListInts.size());
	}
	
}
