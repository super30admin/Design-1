
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : It gives ArrayOutOfBoundsException

// Implemeted HashMap using Double Hashing
class MyHashMap {
    private int primaryBuckets;
    private int secondaryBuckets;
    private Integer[][] storage;

    public MyHashMap() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1001; // Extra space for handling keys up to 10^6
        this.storage = new Integer[primaryBuckets][]; 
    }

    // Primary hash function
    private int getPrimaryHash(int key) {
        return key % primaryBuckets;
    }

    // Secondary hash function (Ensuring valid range)
    private int getSecondaryHash(int key) {
        return key / primaryBuckets;  // Instead of using secondaryBuckets
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            storage[primaryIndex] = new Integer[secondaryBuckets]; 
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = value;
    }

    public int get(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return -1; // Key doesn't exist
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex] == null ? -1 : storage[primaryIndex][secondaryIndex];
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return; // Key doesn't exist
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = null;
    }
}
