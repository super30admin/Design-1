// Time Complexity : O(1)
// Space Complexity : O(range of keys)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried with chaining approach, could not get it work for all edge cases
// Your code here along with comments explaining your approach
// 1. MAP_SIZE = range of elements for keys
// 2. Hash algorithm = key % MAP_SIZE

public class MyHashMap {

    final int MAX = 1000001;
    int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            map[i] = -1;
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key%MAX] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key%MAX];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key%MAX] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */