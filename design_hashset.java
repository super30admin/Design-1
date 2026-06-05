// Time Complexity : O(1) for add, remove and contains operations
// Space Complexity : O(n) where n is the number of elements in the hash set
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Your code here along with comments explaining your approach
//used bucketing to split each key in two parts: key % 1000 gives the bucket index, and key / 1000 gives the position inside that bucket.  

class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1001;
        this.storage = new boolean[buckets][];
    }

    private int hash(int key) {
        return key % buckets;
    }

    private int pos(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int bucket = hash(key);
        int bucketItem = pos(key);

        if (storage[bucket] == null) {
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash(key);
        int bucketItem = pos(key);

        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = hash(key);
        int bucketItem = pos(key);

        return storage[bucket] != null && storage[bucket][bucketItem];
    }
}