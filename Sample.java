// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
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

    private int hash1(int key) {
        return key % this.buckets;
    }

    private int hash2(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
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
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if (storage[bucket] == null)
            return;
        storage[bucket][bucketItems] = false;

    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if (storage[bucket] == null)
            return false;
        return storage[bucket][bucketItems];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
