// Time Complexity : O(1) for all
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    
    boolean[][] set;
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        set = new boolean[buckets][];
        
    }
    
    
    public int getHashBucket(int key){
        return key % buckets;
    }
    
     public int getHashBucketItem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getHashBucket(key);
        int bucketItem = getHashBucketItem(key);
        
        if(set[bucket] == null){
            if(bucket == 0){
            set[bucket] = new boolean[bucketItems + 1];
            } else {
                set[bucket] = new boolean[bucketItems];
            }
        }
        
        set[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getHashBucket(key);
        int bucketItem = getHashBucketItem(key);
        
        if(set[bucket] == null){
            return;
        } else {
            set[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getHashBucket(key);
        int bucketItem = getHashBucketItem(key);
        if(set[bucket] == null){
            return false;
        } else {
            return set[bucket][bucketItem];
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */