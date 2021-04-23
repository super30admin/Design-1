// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : 1 Stack approach


class MyHashMap {

    /** Initialize your data structure here. */
    Integer values[][];
    int primaryArraySize = 1000;
    int secondaryArraySize = 1001;
    public MyHashMap() {
        values = new Integer[primaryArraySize][];
    }
    
    
    int hash1(int key){
        return key % primaryArraySize;
    }
    int hash2(int key){
        return key / secondaryArraySize;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int val1 = hash1(key);
        int val2 = hash2(key);
        if(values[val1] == null){
            values[val1] = new Integer[secondaryArraySize];
        }
        values[val1][val2] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int val1 = hash1(key);
        int val2 = hash2(key);
        if(values[val1] == null || values[val1][val2] == null){
            return -1;
        }
        return values[val1][val2] ;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int val1 = hash1(key);
        int val2 = hash2(key);
        if(values[val1] == null) return;
        values[val1][val2] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
