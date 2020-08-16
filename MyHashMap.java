package design1;

import java.util.Arrays;

//Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Map {

    /** Initialize your data structure here. */
	
	
    int map[];
    //Initialize an array of given max size and set default value to -1
    public Map() {
        map=new int[1000001];
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	//map the given value with the key i.e. specified at given index
        map[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	// returns the value at the given key 
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//Driver code 
class MyHashMap { 
  public static void main(String args[]) 
  { 
		Map hashMap = new Map();
		hashMap.put(3, 1);          
		hashMap.put(4, 2);         
		System.out.println(hashMap.get(3));            // returns 1
		System.out.println(hashMap.get(2));            // returns -1 (not found)
		hashMap.put(3, 7);          					// update the existing value
		System.out.println(hashMap.get(3));            // returns 7 
		hashMap.remove(3);          					// remove the mapping for 3
		System.out.println(hashMap.get(3));            // returns -1 (not found) 
  } 
} 