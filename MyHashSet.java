// Approach:
// We create a 2D boolean array to represent buckets and bucket items to avoid exceeding memory limits.
// When a key is added, we calculate its outer and inner bucket index using hashing functions and set that cell to true.
// When removing or checking existence, we access that exact cell using hash functions.


// Time Complexity : O(1) for add, remove, contains (average case)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    boolean[][] storage;
    int firstBucketSize;
    int secondbucketSize;

    public MyHashSet() {
        // We initialize the first bucket size to 1000 (outer array)
        // and second bucket size to 1001 (inner array) to handle up to 10^6 elements.
        this.firstBucketSize = 1000;
        this.secondbucketSize = 1001;
        this.storage = new boolean[firstBucketSize][];
    }

    public int firsthashingfxn(int key) {
        // This function gives us the outer index
        return key % firstBucketSize;
    }

    public int secondhashingfxn(int key) {
        // This function gives us the inner index
        return key % secondbucketSize;
    }

    public void add(int key) {
        int firstIndex = firsthashingfxn(key);
        // If the outer bucket is empty, initialize its inner array
        if (storage[firstIndex] == null) {
            storage[firstIndex] = new boolean[secondbucketSize + 1];
        }
        int secondIndex = secondhashingfxn(key);
        // Mark the element as present
        storage[firstIndex][secondIndex] = true;
    }

    public void remove(int key) {
        int firstIndex = firsthashingfxn(key);
        // If outer bucket is null, nothing to remove
        if (storage[firstIndex] == null) return;

        int secondIndex = secondhashingfxn(key);
        // Mark the element as not present
        storage[firstIndex][secondIndex] = false;
    }

    public boolean contains(int key) {
        int firstIndex = firsthashingfxn(key);
        // If outer bucket is null, key doesn't exist
        if (storage[firstIndex] == null) return false;

        int secondIndex = secondhashingfxn(key);
        // Return whether the element is present or not
        return storage[firstIndex][secondIndex];
    }
}
