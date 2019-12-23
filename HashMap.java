// Time Complexity :
//      put() - O(1)
//		get() - O()
//		remove - O()
//      
// Space Complexity :
//		overall - O(n)
//      put() - O(1)
//		get() - N/A
//		remove - N/A
//
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

import java.util.Set;
import java.util.HashSet;

class MyHashMap {

	static final int MAX = 1000;
	int[] array;
	Set<Integer> keySet;

	/** Initialize your data structure here. */
    public MyHashMap() {
        array = new int[MAX];
        keySet = new HashSet<Integer>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        array[key] = value;
        keySet.add(key);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //return the value at the index
        if(keySet.contains(key))
        	return array[key];
        else
        	return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //set the value at the index to null
        keySet.remove(key);
    }

	public static void main(String[] args)
	{
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 2);          
		hashMap.put(2, 3);         
		System.out.println("get(1) -> " + hashMap.get(1));            // returns 2
		System.out.println("get(3) -> " + hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 4);          // update the existing value
		System.out.println("get(4) -> " + hashMap.get(2));            // returns 4 
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println("get(2) -> " + hashMap.get(2));            // returns -1 (not found)
	}
}