// Time Complexity : O(1)  for all operations
// Space Complexity : O(n) where N is max keys it can handle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.Arrays;

class MyHashMap {
    private int max;
    private int[] store;
    /** Initialize your data structure here. */
    public MyHashMap() {
        max=1000000+1;
        store=new int[max];
        Arrays.fill(store,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(key>=0 && key<max+1)
            store[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(store[key]==-1)
            return -1;
        
        return store[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        store[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */