// Time complexity: O(1) for all operations
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Double Hashing technique - prevent collisions
class MyHashSet {
    int primaryBucketSize = 1000; // ~= sqrt(10^6 + 1)
    int secondaryBucketsSize = 1000;
    boolean[][] storage;
    public MyHashSet() {
        // Initialize primary storage.
        storage = new boolean[primaryBucketSize][]; // default values are null.
    }
    
    int firstHash(int key) {
        return key % primaryBucketSize;
    }

    int secondHash(int key) {
        return key / secondaryBucketsSize;
    }

    public void add(int key) {
        int firstHashIndex = firstHash(key);
        // Initialize secondary storage when needed
        if (storage[firstHashIndex] == null) {
            // Handle array index out of bound issue while adding 10^6
            storage[firstHashIndex]
                = firstHashIndex == 0
                    ? new boolean[secondaryBucketsSize + 1]
                    : new boolean[secondaryBucketsSize];
        }
        int secondHashIndex = secondHash(key);
        storage[firstHashIndex][secondHashIndex] = true;
    }
    
    public void remove(int key) {
        // Reuse contains() and remove only if present
        if (contains(key)) {
            storage[firstHash(key)][secondHash(key)] = false;
        }
    }
    
    public boolean contains(int key) {
        if (storage[firstHash(key)] == null) {
            return false;
        }
        // Returns true if the key is present, else returns false
        return storage[firstHash(key)][secondHash(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */