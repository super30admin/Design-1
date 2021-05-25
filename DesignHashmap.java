// Time Complexity : put - O(1), get - O(1), remove - O(1)
// Space Complexity : O(1000001) - length of the array used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nothing except I am unsure if this is an acceptable way.


// Your code here along with comments explaining your approach

//The constraints on the leetcode problem says that the range of keys is from 0 to 10^6 (both inclusive)
//Create an array with the specified length and set all the values to -1 by defualt.
//The advantage is the time complexity if O(1) for all three operations which is inline with the time complexities for the same operations on a Hashmap
class MyHashMap {
    int[] values;

    /** Initialize your data structure here. */
    public MyHashMap() {
        values = new int[1000001];
        Arrays.fill(values, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        values[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return values[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        values[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */