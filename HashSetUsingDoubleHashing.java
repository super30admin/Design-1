//Implemented HashSet using "Double Hashing" collision technique

public class HashSetUsingDoubleHashing {
    boolean[][] storage;
    int primaryBuckets;
    int secondaryBuckets;

    public HashSetUsingDoubleHashing() { // SpaceComplexity: O(<< n)
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][]; // 1000 * 2 bytes
    }

    private int getPrimaryHash(int key) {
        return key % primaryBuckets;
    }

    private int getSecondaryHash(int key) {
        return key / secondaryBuckets;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            if (primaryIndex == 0) { // to handle the edge case
                storage[primaryIndex] = new boolean[secondaryBuckets + 1]; // 1001 capacaity subarray
            } else {
                storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;

    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }

    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}

/**
 * Your HashSet object will be instantiated and called as such:
 * HashSet obj = new HashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// TimeComplexity: O(1) for all methods
// Space Complexity: O(N)
// Did this code successfully run on Leetcode? Yes