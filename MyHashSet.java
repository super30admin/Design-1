// Time Complexity: add(), remove(), contains() all have O(1) complexity.
// Space Complexity: Space complexity would be O(buckets * bucketItems).
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Implemented HashSet using double hashing technique.
class MyHashSet {
    private int buckets;
    private int bucketItems;
    private boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int idx1 = hashFunction1(key);
        int idx2 = hashFunction2(key);
        if (storage[idx1] == null) {
            storage[idx1] = new boolean[bucketItems];
        }

        storage[idx1][idx2] = true;
    }
    
    public void remove(int key) {
        int idx1 = hashFunction1(key);
        if (storage[idx1] == null) {
            return;
        }

        int idx2 = hashFunction2(key);

        storage[idx1][idx2] = false;
    }
    
    public boolean contains(int key) {
        int idx1 = hashFunction1(key);
        if (storage[idx1] == null) {
            return false;
        }

        int idx2 = hashFunction2(key);

        return storage[idx1][idx2];
    }

    private int hashFunction1(int key) {
        return key % 1000;
    }

    private int hashFunction2(int key) {
        return key / 1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
