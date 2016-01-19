package com.java.collection;


public class CustomHashMap<K, V> implements CustomMap<K, V> {

	//size of the map
	private int size;
	
	//Element of the map is stored in this array
	private Entry<K, V>[] mapStore;
	
	//Default capacity
	private static final int CAPACITY = 16;
	
	public CustomHashMap(int capacity) {
		this.mapStore = new Entry[capacity];
	}
	
	public CustomHashMap() {
		this.mapStore = new Entry[CAPACITY];
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

		// get the hashcode and regenerate it to be optimum
		int hash = key.hashCode();

		// compute the bucket number (0-15 based on our default size)
		// this always results in a number between 0-15
		int bucket = getBucketNumber(hash);

		// get the element at the above bucket if it exists
		Entry<K, V> existingElement = mapStore[bucket];

		// if bucket is found then traverse through the linked list and
		// see if element is present
		while (existingElement != null) {
			System.out.println("Traversing the list inside the bucket for the key " + existingElement.getKey());
			if (existingElement.key.equals(key)) {
				return existingElement.value;
			}
			existingElement = existingElement.next;
		}

		// if nothing is found then return null
		return null;
	}

	@Override
	public void put(K key, V value) {
	
		// get the hashcode
		int hash = key.hashCode();

		// compute the bucket number (0-15 based on our default size)
		// this always results in a number between 0-15
		int bucket = getBucketNumber(hash);
		
		Entry<K, V> existingElement = mapStore[bucket];
		
		for (; existingElement != null; existingElement = existingElement.next) {
			if (existingElement.key.equals(key)) {
				//System.out.println("duplicate key value pair found, replacing existing key " + key + ", with value " + value);
				existingElement.value = value;
				return;
			} else {
				//System.out.println("Collision detected for key " + key + ", adding element to the existing bucket");
			}
		}
		
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		newEntry.setNext(mapStore[bucket]);
		mapStore[bucket] = newEntry;
		size++;
	}

	@Override
	public boolean containsKey(Object key) {

		int hash = key.hashCode();
		int bucket = getBucketNumber(hash);
		
		Entry<K, V> existingElement = mapStore[bucket];
		
		for (; existingElement != null; existingElement = existingElement.next) {
			if (existingElement.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * User defined map data structure with key and value.
	 * 
	 * This is also used as linked list in case multiple key-value pairs lead to
	 * the same bucket with same hashcodes and different keys (collisions) using
	 * the pointer 'next'.
	 *
	 */
	class Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		Entry(K k, V v) {
			key = k;
			value = v;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}
	}
	
	//It makes sure the bucket number falls within the size of the hashmap
	private int getBucketNumber(int hash) {
		return hash & (size - 1);
	}

}
