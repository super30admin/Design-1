// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot about the edge cases. Faced some problems while implementing if condition
// Approach: Used doushing here to tackle collisions
//           Created nested arrays only when required because it uses less space
//           No default libraries used.

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }
    
    int getBucket(int key){
        return key % this.buckets;
    }

    int getBucketItem(int key){
        return key / this.bucketItems;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            if(bucket == 0){
               storage[bucket] = new boolean[this.bucketItems + 1]; 
            }
            else{
            storage[bucket] = new boolean[this.bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];    
    }
}