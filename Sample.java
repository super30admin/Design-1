// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.HashMap;
class MyHashMap {
 HashMap<Integer,Integer> hashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new HashMap<Integer,Integer>();
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(value>=0)
        hashMap.put(key,value);
    }
    
    /** Returns the value to which 
    the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
            if(hashMap.containsKey(key))
            return hashMap.get(key);
        else
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        hashMap.remove(key);   
    }
}
