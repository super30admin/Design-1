// Time Complexity : O(1) for add, remove, and contains (average case)
// Space Complexity : O(1) effectively (fixed bucket size, not dependent on number of elements inserted)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Handling edge case for key = 10^6 required allocating extra space for primaryIndex = 0 bucket.


// Approach:
// Use a 2D boolean array to simulate a hash set with double hashing.
// First hash (mod) decides the bucket, second hash (division) decides the position inside the bucket.
// Lazy initialization is used to save space, and a special case is handled for index 0 to accommodate max key value.

class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][];
    }

    // Primary hash: distributes keys across 1000 buckets
    private int getPrimaryHashKey(int key) {
        return key % primaryBuckets;
    }

    // Secondary hash: position inside each bucket
    private int getSecondaryHashKey(int key) {
        return key / secondaryBuckets;
    }
    
    public void add(int key) {
        int primaryIndex = getPrimaryHashKey(key);

        // Lazy initialization of bucket to save space
        if (storage[primaryIndex] == null) {
            // Special case for key = 10^6 (falls into bucket 0)
            if (primaryIndex == 0) {
                storage[primaryIndex] = new boolean[secondaryBuckets + 1];
            } else {
                storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }

        int secondaryIndex = getSecondaryHashKey(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHashKey(key);

        // If bucket not initialized, key doesn't exist
        if (storage[primaryIndex] == null) return;

        int secondaryIndex = getSecondaryHashKey(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = getPrimaryHashKey(key);

        // If bucket not initialized, key doesn't exist
        if (storage[primaryIndex] == null) return false;

        int secondaryIndex = getSecondaryHashKey(key);
        return storage[primaryIndex][secondaryIndex];
    }
}