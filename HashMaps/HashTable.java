package HashMaps;

import HashMaps.Generics.LinkedList;

public class HashTable<K,V> {
	private class HTPair{
		K key;
		V value;
		HTPair(K key, V value){
			this.key = key;
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			HTPair op = (HTPair) obj;
			return this.key.equals(op.key);
		}
		@Override
		public String toString() {
			return "{ "+this.key +" - "+this.value+" }";
		}
	}

	private static final int DEFAULT_CAPACITY = 10;
	private LinkedList<HTPair> bucketArray[];
	private int size;
	public HashTable() {
		this(DEFAULT_CAPACITY);
	}
	public HashTable(int cap) {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[cap];
		this.size = 0;
	}
	
	public void put(K key, V value) throws Exception{
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if(bucket == null) {
			bucket = new LinkedList<>();
			bucket.addLast(pta);
			this.bucketArray[bi] = bucket;
			this.size++;
		}else {
			int findAt = bucket.find(pta);
			if(findAt == -1) {
				bucket.addLast(pta);
				this.size++;
			}else {
				HTPair pair = bucket.getAt(findAt);
				pair.value = value;
			}
		}
		
		double lambda = (this.size*1.0)/this.bucketArray.length;
		if(lambda>0.75) {
			this.rehash();
		}
		
	}
	// This method is for making all HashTable operation in O(1) time...
	private void rehash() throws Exception{
		//old bucket array
		LinkedList<HTPair> oba[] = this.bucketArray;
		this.bucketArray = (LinkedList<HTPair> [])new LinkedList[2 * oba.length];
		this.size = 0;
		for(LinkedList<HTPair> ob: oba) {
			while(ob != null && !ob.isEmpty()) {
				HTPair pair = ob.removeFirst();
				this.put(pair.key, pair.value);
			}
		}
	}
	private int hashFunction(K key) {
		int hashValue = key.hashCode();
		hashValue = Math.abs(hashValue);
		return hashValue%this.bucketArray.length;
	}
	
	
	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key,null);
		if(bucket == null) {
			return null;
		}else {
			int find = bucket.find(pta);
			if(find == -1) {
				return null;
			}else {
				HTPair pair = bucket.getAt(find);
				return (V) pair.value;
			}
		}
	}
	
	public V remove(K key) throws Exception{
		int bestIndex = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bestIndex];
		HTPair pta = new HTPair(key, null);
		if(bucket == null) {
			return null;
		}else {
			int find = bucket.find(pta);
			if(find == -1) {
				return null;
			}else {
				HTPair pair = bucket.removeAt(find);
				this.size--;
				return (V) pair.value;				
			}
		}
	}
	
	public void display() throws Exception {
		for(LinkedList<HTPair> bucket: this.bucketArray) {
			if(bucket != null && !bucket.isEmpty()) {
				bucket.display();
			}else
				System.out.println("NULL");
		}
		System.out.println("--________________________________________--");
	}
}
