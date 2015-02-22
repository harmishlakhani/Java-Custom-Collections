package com.java.collection;


public class CustomHashMap<K, V> implements CustomMap<K, V> {

	//size of the List
	private int size;
	
	//Element of the list is stored in this array
	private Object[] listStore;
	
	//Default capacity
	private static final int CAPACITY = 10;
	
	public CustomHashMap(int capacity) {
		this.listStore = new Object[capacity];
	}
	
	public CustomHashMap() {
		this.listStore = new Object[CAPACITY];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
