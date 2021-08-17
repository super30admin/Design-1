// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Only implemented the maping part need to implement hashing and collision avoidance. Passes all test cases.

// Your code here along with comments explaining your approach
class MyHashMap {
    Integer[] map;

    public MyHashMap() {
        this.map = new Integer[1000001];
    }
    
    public void put(int key, int value) {
        this.map[key] = value;
    }
    
    public int get(int key) {
        if (this.map[key] == null)
            return -1;
        return this.map[key];
    }
    
    public void remove(int key) {
        this.map[key] = null;
    }
}