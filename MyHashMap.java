// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Referred for implementation of Hash Map as an array

import java.util.Arrays;
class MyHashMap {

    /** Initialize your data structure here. */
    int[] arr = new int[1000001];
    public MyHashMap() {
        Arrays.fill(arr, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}

