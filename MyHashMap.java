import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


//before I thought of taking two
class MyHashMap {

    
    int[] dict;
    /** Initialize your data structure here. */
    public MyHashMap() {
        
         dict = new int[1000001];
         Arrays.fill(dict,-1);
           
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
       dict[key] = value;
          
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(dict[key]!=-1)
            return dict[key];
        else
            return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
          dict[key]= -1;
    }
}