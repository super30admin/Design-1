// Time Complexity : O(1)
// Space Complexity : O(N)  [here if "MAX" i.e. length of array is considered constant then it's O(1)]
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class MyHashMap {

    int[] array;

    static int MAX = 1000001; // as per constraint range is from 0 to 10^6

    /** Initialize your data structure here. */
    public MyHashMap() {
        array = new int[MAX];

        // initializing all array items to -1
        for (int i = 0; i < MAX; i++) {
            array[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        array[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        return array[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        array[key] = -1;
    }
}