// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class MyHashSet {

    private boolean[][] store;
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
    this.buckets = 1000;
    this.bucketItems = 1000;
    this.store = new boolean[this.buckets][];
    }

    private int hash(int key) {
        return key%buckets;
    }

    private int doubleHash(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {

        int bucket = hash(key);
        int bucketItem = doubleHash(key);
        
        if(store[bucket] == null) {
            if(bucket == 0) {
                store[bucket] = new boolean [bucketItems + 1];
            } else {
                store[bucket] = new boolean [bucketItems];
            }
        }
            store[bucket][bucketItem] = true;

    }
    
    public void remove(int key) {
        int bucket = hash(key);
        int bucketItem = doubleHash(key);

        if(store[bucket] == null) {
            return;
        }
        store[bucket][bucketItem] =false;
    }
    
    public boolean contains(int key) {
           int bucket = hash(key);
        int bucketItem = doubleHash(key);
            if(store[bucket] == null) {
            return false;
        }
        return store[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */