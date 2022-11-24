// Time Complexity : O(1) bcz we should ignore constructor. we only have to consider user oriented methods.
// Space Complexity : O(n)
// With double hasing technique we are designing hashset, here we are creating 2D array because when keys are 2,1000000 we are going create 1D array of 1 to 1000000 whereas in 2d array we are going to create 1000 and just in the block 0 and 1 we are going to subArray , which is so efficent
class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    public MyHashSet() {
        buckets= 1000;
        bucketItems = 1001; // edge case for 0 and million with hash1 function is going to give the same value
        storage = new boolean[buckets][];
    }
    
    public int hash1(int key){
        return key % buckets;
    }
    
    public int hash2(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket =  hash1(key);
        int bucketItem = hash2(key);
        
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket =  hash1(key);
        int bucketItem = hash2(key);        
        if(storage[bucket] != null){
           storage[bucket][bucketItem] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int bucket =  hash1(key);
        int bucketItem = hash2(key);
        
        if(storage[bucket] != null){
            return storage[bucket][bucketItem];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */