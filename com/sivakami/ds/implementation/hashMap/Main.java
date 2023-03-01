package com.sivakami.ds.implementation.hashMap;

public class Main {
	
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 2);          
		hashMap.put(2, 3);         
		hashMap.get(1);            // returns 2
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 4);          // update the existing value
		hashMap.get(2);            // returns 4 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found)
	}
}
