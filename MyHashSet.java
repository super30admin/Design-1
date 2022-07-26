// Time Complexity :
// 1. For add operation, O(1)
// 2. For remove operation, O(1)
// 3. For contains operation, O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key%buckets;
    }
    
    private int hash2(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if (storage[hash1] == null) {
            if (hash1 == 0) {
                storage[hash1] = new boolean[bucketItems+1];
            } else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if (storage[hash1] == null) return;
        
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if (storage[hash1] == null) return false;
        
        return storage[hash1][hash2];
    }
}

// Your code here along with comments explaining your approach
