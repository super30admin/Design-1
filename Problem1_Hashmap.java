package design1;

import java.util.*;

class MyHashMap {// Time O(n) no. of elements and Space constant. 

    /** Initialize your data structure here. */
    int[] arr = new int[1000000];
    public MyHashMap() {
        Arrays.fill(arr, -1);
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value ;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (key < 0 || key > 1000000 || arr[key] == -1){
            return -1;
        }else{
            return arr[key];
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
            arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */