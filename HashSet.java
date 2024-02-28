class MyHashSet {
    
    /**
    
    Thought Process
    
    Need to design a hash function var. Check input n value
    Here n = 10^6
    So hash func = sqrt(10^6) = 1000
    
    Implementation - Double Hashing
    1. Buckets -> key % 1000
    2. BucketItems -> key / 1000
    
    DS -> 2D Array (storage) = Initializing storage[Buckets][]
    Allocating storage bucketitems whenever bucket has null bucketitems. So saving memory.
    
    Add -> if (storage[bucket] is null) make new storage[bucket][bucketitem] and add to it
    Remove -> if not exist / null, return. Otherwise mark false
    **/

    int buckets;
    int bucketItems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        //Edge case
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    
    public int bucketHashValue(int key){
        return key % buckets;
    }
    
    public int bucketItemsHashValue(int key){
        return key % bucketItems;
    }
    
    public void add(int key) {
        int bucketHashVal = bucketHashValue(key);
        int bucketItemsHashVal = bucketItemsHashValue(key);
        
        if(storage[bucketHashVal] == null){
            storage[bucketHashVal] = new boolean[bucketItems];
        }
        storage[bucketHashVal][bucketItemsHashVal] = true;
    }
    
    public void remove(int key) {
        
        int bucketHashVal = bucketHashValue(key);
        int bucketItemsHashVal = bucketItemsHashValue(key);
        
        if(storage[bucketHashVal] == null) return;
        storage[bucketHashVal][bucketItemsHashVal] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int bucketHashVal = bucketHashValue(key);
        int bucketItemsHashVal = bucketItemsHashValue(key);
        
        if(storage[bucketHashVal] == null) return false;
        return storage[bucketHashVal][bucketItemsHashVal];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
