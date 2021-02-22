
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;

class MyHashMap {

	/** Initialize your data structure here. */
	int arr[];

	public MyHashMap() {
		arr = new int[1000001]; // creating an array of size 1000001 as
										// given the maximum range in the problem

		Arrays.fill(arr, -1); // Initializing all elements to -1
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		arr[key] = value; // Assigning Value to that particular key or index
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		return arr[key]; // Simply returning the element at particular key
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		arr[key] = -1; // Reassigning the element to -1 in order to get //rid of the previous element
	}
}