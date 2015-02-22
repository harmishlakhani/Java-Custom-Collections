package com.java.collection;

public interface CustomMap<K, V> {

	int size();
	
	boolean isEmpty();
	
	V get(Object key);
	
	V put(K key, V value);
	
	V remove(Object key);
	
	boolean containsKey(Object key);
	
	boolean containsValue(Object value);
}
