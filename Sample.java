// Time Complexity :  O(1) for add, remove and contain operations
// Space Complexity : O(N) worst case when elements hashed to all buckets(1000x1000)  
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketOfItems;
    
    public MyHashSet() {    
        this.buckets =1000;
        this.bucketOfItems=1000;
        this.storage = new boolean[buckets][];
    }
    
    public int hash1(int key)     
    {
        return key%buckets;
    }
    
    public int hash2(int key)     
    {
        return key/bucketOfItems;
    }
    
    public void add(int key) { // O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1]==null){
            if (hash1 ==0){
                storage[hash1] = new boolean[bucketOfItems+1];
            }
            else{ 
                storage[hash1] = new boolean[bucketOfItems];
            }
        }
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {  // O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1]==null ) return;
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {  // O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1]==null ) return false;
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
