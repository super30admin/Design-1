// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : is time complexity right for this problem i am a bit confused.

import java.util.Arrays;

class MyHashMap {

	/** Initialize your data structure here. */
	int arrHash[];

	public MyHashMap() {
		arrHash = new int[1000001]; // Array of size 1000001 is created
										

		Arrays.fill(arrHash, -1); // Initialize all elements to -1
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		arrHash[key] = value;  // value is assigned to the key which is index of the Array
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		return arrHash[key]; // Returns the value with the particular key
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		arrHash[key] = -1; // Assigning the value to -1, i.e discarding the value 
	}
}