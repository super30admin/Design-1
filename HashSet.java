// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes, https://leetcode.com/problems/design-hashset/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int itemBuckets;


    public MyHashSet() {
        this.buckets = 1000;
        this.itemBuckets = 1000;
        this.storage = new boolean[buckets][];
    }

    public int hash1(int key){
        return key%buckets;
    }

    public int hash2(int key){
        return key/itemBuckets;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket] = new boolean[itemBuckets+1];
            }else{
                 storage[bucket] = new boolean[itemBuckets];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
       int bucket = hash1(key);
       int bucketItem = hash2(key);
       if(storage[bucket]==null) return;
       storage[bucket][bucketItem] = false; 
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket]==null) return false;
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
