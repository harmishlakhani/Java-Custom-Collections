package com.application;

import com.java.collection.CustomHashMap;
import com.java.collection.CustomMap;

public class CustomHashMapClient {

	public static void main(String[] args) {
		
		CustomMap<Integer, String> map = new CustomHashMap<>();
		
		//Adding elements to map
		map.put(1, "Harmish");
		map.put(2, "Lakhani");
		//map.put(2, "Lakhani Dup");
		
		//size
		System.out.println("Size is " + map.size());
		
		//Getting values from map
		if(!map.isEmpty()) {
			System.out.println(map.get(1));
			System.out.println(map.get(2));
		}
		
		//return true
		System.out.println("Map contains key 1 " + map.containsKey(1));
		System.out.println("Map contains key 2 " + map.containsKey(2));
		
		//return false
		System.out.println("Map contains key 3 " + map.containsKey(3));
	}
	
}
