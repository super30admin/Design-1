// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes i got Arrayindexoutofbound exception error and 
// resolved it succesfully


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int getBucket(int key)
    {
        return key % buckets;
    }
    private int getBucketItems(int key)
    {
        return key / bucketItems;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket] == null)
        {
            if(bucket == 0)
            {
                storage[bucket] = new boolean[bucketItems + 1]; 
            }
            else
            {
                storage[bucket] = new boolean[bucketItems];
            }
        }
       storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket] == null)
        {
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket] == null)
        {
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