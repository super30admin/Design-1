//Time Complexity 
//Add Operation: O(1)
//Remove Operation: O(1)
//Contains: O(1)
// Did this code successfully run on Leetcode : Yes

class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int getBucket(int key) {
        return key % buckets; //get the index of the primary array
    }
    
    private int getBucketItem(int key) {
        return key / bucketItems;   //get the index of the secondary array
    }
    
public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0)
                storage[bucket] = new boolean[bucketItems + 1]; //Handles upperbound of the size limit
            else
                storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return;
        }
        
        storage[bucket][bucketItem] = false; //overriding the index to false
        
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {   //if primary array is null, return false
            return false;
        }
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