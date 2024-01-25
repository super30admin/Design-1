// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO
class MyHashSet {

    private Boolean[][] storage;
    private int buckets;
    private int bucketItems;


    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new Boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = getBucketVal(key);
        int bucketItem = getBucketItemVal(key);

        if(storage[bucket] == null) {
            storage[bucket] = new Boolean[bucketItems+1];
        } else {
            storage[bucket] = new Boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    private int getBucketVal(int val) {
        return val%buckets;
    }

    private int getBucketItemVal(int val) {
        return val/bucketItems;
    }
    
    public void remove(int key) {
        int bucket = getBucketVal(key);
        int bucketItem = getBucketItemVal(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;

    }
    
    public boolean contains(int key) {
        int bucket = getBucketVal(key);
        int bucketItem = getBucketItemVal(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */