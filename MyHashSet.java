// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyHashSet {

    private boolean [] [] storage;
    private int buckets;
    private int bucketitems;
    public int hash1(int key) {
        return key%buckets;
    }
    public int hash2(int key) {
        return key/bucketitems;
    }
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketitems = 1000;
        this.storage = new boolean [1000] [];
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketitems +1];
            }
            else {
                storage[bucket] = new boolean[bucketitems];
            }
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = true ;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) return ;
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) return false;
        int bucketItem = hash2(key);
            return storage[bucket][bucketItem];
        
    }
}
