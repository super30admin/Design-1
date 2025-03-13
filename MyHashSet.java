// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the hashset
// Did this code successfully run on Leetcode : Yes

class MyHashSet {

    int primaryBucketSize = 1000;
    int secondaryBucketSize = 1001;
    public boolean[][] storage;

    public MyHashSet() {
        storage = new boolean[primaryBucketSize][];
    }

    public int getPrimaryHash(int key) {
        return key / secondaryBucketSize;
    }

    public int getSecondaryHash(int key) {
        return key % secondaryBucketSize;
    }

    public void add(int key) {
        int primaryHash = getPrimaryHash(key);
        int secondaryHash = getSecondaryHash(key);
        if(storage[primaryHash] == null) {
            storage[primaryHash] = new boolean[secondaryBucketSize];
        }
        storage[primaryHash][secondaryHash] = true;
    }

    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        int secondaryHash = getSecondaryHash(key);
        if (storage[primaryHash] != null) {
            storage[primaryHash][secondaryHash] = false;
        }
    }

    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        int secondaryHash = getSecondaryHash(key);

        if (storage[primaryHash] == null) {
            return false;
        }
        return storage[primaryHash][secondaryHash];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
