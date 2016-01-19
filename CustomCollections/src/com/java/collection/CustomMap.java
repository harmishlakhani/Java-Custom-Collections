package com.java.collection;

public interface CustomMap<K, V> {

	int size();
	
	boolean isEmpty();
	
	V get(Object key);
	
	void put(K key, V value);
	
	boolean containsKey(Object key);

}
