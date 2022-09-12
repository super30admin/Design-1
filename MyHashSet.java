// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    
    boolean storage[][];
    int bucket;
    int bucketItem;
    

    public MyHashSet() {
        bucket = 1000;
        bucketItem = 1000;
        storage = new boolean[bucket][];
    }
    
    private int getBucket(int key){
        return key % bucket;
    }
    
    private int getBucketItems(int key){
        return key / bucketItem;
    }
    
    public void add(int key) {
            int buckets = getBucket(key);
            int bucketItems = getBucketItems(key);
            if(storage[buckets] == null){
                if(buckets == 0){
                    storage[buckets] = new boolean[bucketItem + 1];
                }
                else{
                    storage[buckets] = new boolean[bucketItem];
                }
            }
            storage[buckets][bucketItems] = true;   
    }
    
    public void remove(int key) {
            if(storage[getBucket(key)] == null)
                return;
            storage[getBucket(key)][getBucketItems(key)] = false;      
    }
    
    public boolean contains(int key) {
        if(storage[getBucket(key)] == null)
            return false;
        return storage[getBucket(key)][getBucketItems(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
