import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes, still identifying how to determine the array size and use hashfunc


public class MyHashMap {
    int newkey =0;
    int[] arr;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[100000];
        
        //To initialize the value with -1
        Arrays.fill(arr,-1);
        
    }
    
    private int hashfunc(int key)
    {
        return(key%100000);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        newkey = hashfunc(key);
        arr[newkey]= value;
      
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        newkey = hashfunc(key);
        return arr[newkey];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        newkey = hashfunc(key);
        arr[newkey]= -1;
        
    }
    
}
