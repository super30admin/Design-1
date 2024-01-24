// Time Complexity : O(1) for all operations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int firstHashFunction(int key) {
        return key % this.buckets;
    }

    private int secondHashFunction(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = firstHashFunction(key);
        int bucketItem = secondHashFunction(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = firstHashFunction(key);
        int bucketItem = secondHashFunction(key);

        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {

        int bucket = firstHashFunction(key);
        int bucketItem = secondHashFunction(key);

        if (storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }

}
