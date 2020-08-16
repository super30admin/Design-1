package com.Aug2020;

import java.util.Arrays;

//Time Complexity : O(1)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
// How much size should we decide for integer array for this problem?
// Earlier tried using iterative approach in such case time complexity increases.

//Your code here along with comments explaining your approach

class MyHashMap {

	Integer[] map;
	int counter;

	/** Initialize your data structure here. */
	public MyHashMap() {
		map = new Integer[10000001];
		counter = 0;
		Arrays.fill(map, -1);
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		if (counter < map.length) {

			map[key] = value;
		}
		counter++;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		return map[key] != null ? map[key] : -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		map[key] = -1;

	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */