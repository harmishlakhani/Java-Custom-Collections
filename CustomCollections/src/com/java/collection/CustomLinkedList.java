package com.java.collection;

public class CustomLinkedList<E> implements CustomList<E> {

	//size of the List
	private int size;
	
	//head of the list
	private Node<E> head;
	
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
		
		Node<E> node = new Node<E>();
		node.setData(element);
		size++;
		
		Node<E> temp = head;
		if (temp == null) {
			head = node;
			return true;
		}
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
		
		return true;
	}

	@Override
	public E remove(int index) {
		
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index is greater than size of LinkedList!!! \n "
					+ " Index : " + index + " Size : " + size);
		}
		size--;
		Node<E> temp = head;
		if (index == 0) {
			head = temp.getNext();
			temp.setNext(null);
			return temp.getData();
		} else {
			int count = 1;
			while (temp != null && count < index - 1) {
				temp = temp.getNext();
				count++;
			}
			Node<E> temp2 = temp.getNext();
			temp.setNext(temp2.getNext());
			E value = temp2.getData();
			temp2 = null;
			return value;
		}
		
	}

	@Override
	public E get(int index) {
		
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index is greater than size of LinkedList!!! \n "
					+ " Index : " + index + " Size : " + size);
		}
		
		int count = 0;
		Node<E> temp  = head;
		while (count < index) {
			temp =  temp.getNext();
			count++;
		}
		return (E) temp.getData();
	}

}

class Node<E> {
	
	private E data;
	private Node<E> next;

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
}