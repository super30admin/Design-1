// Time Complexity : All functions O(1)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class MyHashSet {
    private int buckets;
    private int bucketItems;
    private boolean[][] storage;
    private int hash1(int key){
        return key%buckets;
    }
    private int hash2(int key){
        return key/bucketItems;
    }
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        if(storage[bucket]==null){
            if(bucket==0)
                storage[bucket] = new boolean[1001];
            else
                storage[bucket] = new boolean[1000];
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket]==null)
            return;
         int bucketItem = hash2(key);
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        if(storage[bucket]==null)
            return false;
        int bucketItem = hash2(key);
        return storage[bucket][bucketItem] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */