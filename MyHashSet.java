// Time Complexity : O(1) for all operations search, add, remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyHashSet {

    private boolean[][] storage;
    private int bucketSize;
    private int bucketItems;

    public MyHashSet() {
        this.bucketSize = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[this.bucketSize][];
    }

    private int bucket(int key) {
        return key % this.bucketSize;
    }

    private int bucketItem(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucketKey = this.bucket(key);
        int bucketItemKey = this.bucketItem(key);
        if (this.storage[bucketKey] == null) {
            if (bucketKey == 0) {
                this.storage[bucketKey] = new boolean[this.bucketItems + 1];
            } else {
                this.storage[bucketKey] = new boolean[this.bucketItems];
            }
        }
        this.storage[bucketKey][bucketItemKey] = true;
    }

    public void remove(int key) {
        int bucketKey = this.bucket(key);
        int bucketItemKey = this.bucketItem(key);
        if (this.storage[bucketKey] == null)
            return;
        this.storage[bucketKey][bucketItemKey] = false;
    }

    public boolean contains(int key) {
        int bucketKey = this.bucket(key);
        int bucketItemKey = this.bucketItem(key);
        if (this.storage[bucketKey] == null)
            return false;
        return this.storage[bucketKey][bucketItemKey];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */