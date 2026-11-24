// Time Complexity: O(1) for add, remove and contains.
// Space Complexity: O(n), where n is the range of possible keys.

// Approach: Use a 2D boolean array and two hash functions to find the bucket and the position of a key within it.
// Initialize a bucket only when a key is added to it for the first time.
// Mark the position as true when adding a key, false when removing it, and check its value to see if the key exists.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[this.buckets][];
        
    }
    public int hash1(int key){
        return key % this.buckets;
    }
    public int hash2(int key){
        return key / this.bucketItems;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket]== null){
            if(bucket == 0){
                storage[bucket] = new boolean[this.bucketItems+1];
            }else{
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
        return;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] != null){
            storage[bucket][bucketItem] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            return false;
        }
        if(storage[bucket][bucketItem] == true){
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
