// Time Complexity :
// add()      -> O(1)
// remove()   -> O(1)
// contains() -> O(1)

// Space Complexity : O(10^6)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
// No issues. Just had to remember that Java initializes boolean arrays to `false` by default.

// Your code here along with comments explaining your approach:

class MyHashSet {

    // Create a boolean array to directly map key to index
    private boolean[] storage;

    public MyHashSet() {
        // Key range is from 0 to 10^6 inclusive, so array size = 1_000_001
        storage = new boolean[1_000_001];
    }

    public void add(int key) {
        // Set value at key index to true
        storage[key] = true;
    }

    public void remove(int key) {
        // Set value at key index to false
        storage[key] = false;
    }

    public boolean contains(int key) {
        // Return boolean value at key index
        return storage[key];
    }
}
