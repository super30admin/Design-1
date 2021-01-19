// Time Complexity : O(1)
// Space Complexity O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// 1. create a new array of required size; (1000001 given in problem statement)
// 2. PUT value at key==index of array; array[key] = value
// 3. GET key will be array[key]
// $. REMOVE set value of array[key] to -1

class MyHashMap {
    
    int size = 1000001;
    int[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[size];
        Arrays.fill(map,-1);
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
        map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
