class MyHashSet {

    /*
        Using 2d boolean array and double hashing method, when we want to add a key to the set, 
        we use the hash values to find the place in the array in O(1) time.
        The first hash function gives the index for the main array and the second hash helps us identify
        the place in the secondary array. To add a new value, we set the boolean to true at the calculated index.
        To remove from the array, we set the value to false at the calculated index.

        // Time Complexity : push, pop, peek, getMin - O(1)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
    */

    private boolean[][] storage;
    private Integer bucket;
    private Integer bucketItem;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.storage = new boolean[bucket][];
    }

    private int hash1(int key) {
        return key % this.bucket;
    }

    private int hash2(int key) {
        return key / this.bucketItem;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[this.bucketItem + 1];
            } else {
                storage[bucket] = new boolean[this.bucketItem];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */