// Time Complexity : O(1) average for add, remove, contains
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues; mostly indexing logic.

// I used a 2D boolean array to simulate hashing with double hashing.
// The first hash maps to a bucket, and the second hash maps to the bucket index.
// When a bucket is needed, it is lazily initialized to save memory.
class MyHashSet {
private int bucket;
private int bucketItems;
private boolean [][]storage;

    public MyHashSet() {
        this.bucket=1000;
        this.bucketItems=1000;
        this.storage = new boolean [bucket][];
        
    }
    private int hash1(int key){
        return key % this.bucket;
    }
    private int hash2(int key){
        return key/1000;

    }
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage [bucket]== null){
        storage [bucket] = new boolean [bucketItems];
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage [bucket]== null)return ;
        storage[bucket][bucketItem]=false;

    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null)return false;
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
