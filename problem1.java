// Time Complexity : O(1) for add, remove and contains operations
// Space Complexity : O(1000 * 1001) for the hashset array - from the problem constraints
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// My approach was to use a 2D boolean array to represent the hashset as discussed in the first class.
// First hash is to find the index of remainder, second hash is to find the thousandth place.
// I set the value [1000][1001] because the problem constraints say that the key will be in the range of 0 to 10^6.

class MyHashSet {
    private boolean[][] hashset;
    public MyHashSet() {
        this.hashset = new boolean[1000][1001];
    }
    
    public void add(int key) {
        this.hashset[key%1000][key/1000] = true;
    }
    
    public void remove(int key) {
        this.hashset[key%1000][key/1000] = false;
    }
    
    public boolean contains(int key) {

        return this.hashset[key%1000][key/1000];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */