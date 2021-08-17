// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Got stuck in middle, saw the answer and wrote again. I will try mutiple ways to answer this question.

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

// Your code here along with comments explaining your approach
