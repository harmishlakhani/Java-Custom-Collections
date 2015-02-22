package com.java.collection;

import java.util.Arrays;

public class CustomArrayList<E> implements CustomList<E> {

	//size of the List
	private int size;
	
	//Element of the list is stored in this array
	private Object[] listStore;
	
	//Default capacity
	private static final int CAPACITY = 10;
	
	public CustomArrayList(int capacity) {
		this.listStore = new Object[capacity];
	}
	
	public CustomArrayList() {
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
	public boolean add(E element) {
		if(size == this.listStore.length) {
			increaseCapacity(size * 2);
		}
		this.listStore[size] = element;
		size++;
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index is greater than size of ArrayList!!! \n "
					+ " Index : " + index + " Size : " + size);
		}

		E value = (E) this.listStore[index];
		System.arraycopy(this.listStore, index + 1, this.listStore, index, size - index - 1);
		size--;
		this.listStore[size] = null;
		
		if(size <= (this.listStore.length / 4)) {
			decreaseCapacity(this.listStore.length / 2);
		}
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index is greater than size of ArrayList!!! \n "
					+ " Index : " + index + " Size : " + size);
		}
		return (E) this.listStore[index];
	}

	//This will create list store with doubling its size. 
	private void increaseCapacity(int capacity) {
		this.listStore = Arrays.copyOf(listStore, capacity);
	}

	//This will create list store with doubling its size. 
	private void decreaseCapacity(int capacity) {
		this.listStore = Arrays.copyOf(listStore, capacity);
	}
}
