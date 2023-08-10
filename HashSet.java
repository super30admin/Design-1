// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The values are mapped to the array by using double hashing to resolve collisons here(hash1 and hash2). The primary array storage will save the
// the address to the secondary array which inturn will save the elements in it post computing the hash value using hash2. The index range for 
// both primary and the secondary array are taken based on square root method on the upper bound provided.

class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];    
    }

    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            if(bucket==0){
                storage[bucket] = new boolean[bucketItems+1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket]==null){
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