// Time Complexity :O(1) for every method (add, remove, contains)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class HashSet {

    boolean[][] storage;
    int buckets, bucketItems;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        
        storage = new boolean[buckets][];     
    }
    
    public int getBucket(int key) {
        return key % 1000;
    }
    
    public int getBucketItem(int key) {
        return key / 1000;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems+1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null) {
            return;
        }
        
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null) {
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