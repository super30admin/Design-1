// Time Complexity : O(1) for every operation
// Space Complexity : The array of size - 1000000
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {

    /** Initialize your data structure here. */
    private int[] hashmap;
    public MyHashMap() {
        hashmap = new int[1000000];
        for(int i=0;i<1000000;i++){
            hashmap[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashmap[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashmap[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashmap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */