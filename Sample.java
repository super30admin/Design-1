// Time Complexity : O(1)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

// I used double hashing for handling collision.
// Firstly created square Root size of array and created nested array only when needed.

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            }
             else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }



    public void remove(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if (key < 1000000) {
            if (storage[bucket] == null) {
                return;
            }
            if (storage[bucket][bucketItem] == false) {
                return;
            }
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if (key < 1000000) {
            if (storage[bucket] == null) {
                return false;
            }
            if (storage[bucket][bucketItem] == false) {
                return false;
            }
        }
        return true;
    }
}
