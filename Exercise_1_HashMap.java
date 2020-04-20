// Time Complexity : put(), get(), remove() -> O(1) for each element 
// Space Complexity : O(n) where n is the length of the array store (n = 1000001)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Initially I went with an ArrayList but I faced errors in the case 
 * if the index remains unfilled. Hence, I went with integer array, with the sacrifice to the amount of space that it is 
 * using which is high but that's the max amount of key value pairs allowed in the hashmap.
 */
import java.util.Arrays;
class MyHashMap {

	// Your code here along with comments explaining your approach

    int[] store;
    /** Initialize your data structure here. */
    public MyHashMap() {
        store = new int[1000001]; // Max number of key-value pairs allowed in the HashMap, cant exceed it.
        Arrays.fill(store, -1);  // we have to anyways return -1 if key doesn't exists.
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        store[key] = value;  // update operation= overwritten 
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return store[key];    // get the value for the key
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        store[key] = -1;  // If the key is removed, the value of that key is replaced with -1, 
        				// that the item doesn't exist because hashmap requires removal of keys.
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


