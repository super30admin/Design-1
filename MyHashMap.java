// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyHashMap {

    // Size of arr accoring to LC specification
    static int MAX_SIZE = 1000000;

    // Defining arr
    int[] map_arr = new int[MAX_SIZE];

    /** Initialize your data structure here. */
    //Initialize all to -1
    public MyHashMap() {
        for(int i=0; i<MAX_SIZE; i++)
            map_arr[i] = -1; 

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map_arr[key] = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map_arr[key];

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map_arr[key] = -1;
    }
}