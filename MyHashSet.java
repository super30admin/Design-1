// Time Complexity : O(1) for add, remove, contains
// Space Complexity : O(n) for the storage
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage; // To hold the keys
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
            
        if(storage[bucket] == null){
           if(bucket == 0){
           		// To handle the corner case, 0 and 1000000 both map to the same index in double hashing
                storage[bucket] = new boolean[bucketItems + 1];
            }else{
                storage[bucket] = new boolean[bucketItems];
            } 
        }    
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
            
        if(storage[bucket] == null){
            return;
        }
        
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket] == null){
            return false;
        }
        
        return storage[bucket][bucketItem];
    }
    
    private int getBuckets(int key){
        return key % buckets;
    }
    
    private int getBucketItems(int key){
        return key / bucketItems;
    }
}

