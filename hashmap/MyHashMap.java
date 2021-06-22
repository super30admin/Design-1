// Time Complexity : O(n/k), k->bucket size = 4987
// Space Complexity : O(k+u), u-> unique keys in hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
//Took some time figuring out hash functions. After class, 
//decided to go with the prime number approach

package hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
	List<HashTable> table;
	int hashKey;

	/** Initialize your data structure here. */
	public MyHashMap() {
		// HashFunction = key % 4987 (4987 is a prime number)
		this.table = new ArrayList<HashTable>();
		this.hashKey = 4987;
		for (int i = 0; i < this.hashKey; ++i) {
			this.table.add(new HashTable());
		}
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		// Get the hashcode of the key, and put data into that specific bucket.
		this.table.get(key % this.hashKey).put(key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		// Get the hashcode of the key, and look for data in that specific bucket.
		return this.table.get(key % this.hashKey).get(key);
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		// Get the hashcode of the key, and remove data from that specific bucket.
		this.table.get(key % this.hashKey).remove(key);
	}

	public void printMap() {
		for (HashTable kvp : this.table) {
			if (kvp.toString() != null) {
				System.out.println(kvp.toString());
			}
		}
	}

	public static void main(String[] args) {
		MyHashMap obj = new MyHashMap();
		obj.put(1, 1);
		obj.put(2, 2);
		obj.put(2000, 3);
		obj.put(5000, 6);
		obj.put(5, 745);
		System.out.println("obj.get(3)=" + obj.get(3));
		System.out.println("obj.get(1)=" + obj.get(1));
		System.out.println("obj.get(2000)=" + obj.get(2000));
		System.out.println("obj.get(5000)=" + obj.get(5000));
		System.out.println("Removing obj(2)..");
		obj.remove(2);
		obj.printMap();
	}

}
