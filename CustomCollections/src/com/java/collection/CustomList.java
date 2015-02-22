package com.java.collection;

public interface CustomList<E> {

	int size();
	
	boolean isEmpty();
	
	boolean add(E e);
	
	E get(int index);
	
	E remove(int index);
}
