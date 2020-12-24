// Time Complexity :0(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :none

// Your code here along with comments explaining your approach

import java.util.Arrays;

class MyHashMap {

    private int array[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        //Create array and initialize all elements to -1
        array = new int[1000000];
        Arrays.fill(array, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        //set value for a given key
        array[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //returns value of key
        return array[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //set value to -1
        array[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */