
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : Yes, Too big of an array. Waste of space and time.


// Your code here along with comments explaining your approach
import java.util.Arrays;
class MyHashMap {
    int[] arr;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[1000000];
        Arrays.fill(arr,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%1000000;
        arr[index] = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%1000000;
        return arr[index];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%1000000;
        arr[index]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */