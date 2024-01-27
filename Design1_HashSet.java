// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    private boolean[][] storage;
    private int bucket;
    private int bucketItem;
    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.storage = new boolean[bucket][];
    }
    
    private int bucket(int key) {
        return key % this.bucket;
    }

    private int bucketItem(int key) {
        return key / this.bucketItem;
    }
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[this.bucketItem + 1];
            }else {
                storage[bucket] = new boolean[this.bucketItem];
            }
        }

        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
         int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
}