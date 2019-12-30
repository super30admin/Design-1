// 706. Design HashMap
// S30 Big N Problem #1 {Easy}
// Time Complexity : O(1) for get, put, remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :

// 23 / 33 test cases passed.
// Status: Runtime Error
// ArrayIndexOutOfBoundsException

// Your code here along with comments explaining your approach
// Initializing large size arrays 
class MyHashMap {
    
    int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[90001];
        Arrays.fill(map,-1);
        //System.out.println(Arrays.toString(map));
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */