class MyHashSet {
    
     int buckets = 1000;
     int bucketItems = 1001;
     boolean [][] storage = new boolean [buckets][];
        
     int bucket(int val) 
        {
            return val % buckets;
         }
        
    int bucketItem(int val)
        {
            return val/buckets;
        }  

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if (storage[bucket] == null)
            {
                storage [bucket] = new boolean [bucketItems];
            }   
        storage [bucket][bucketItem] = true;
        
        
        
    }
    
    public void remove(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if (storage[bucket] != null)
            {
                storage [bucket] = new boolean [bucketItems];
            }   
        storage [bucket][bucketItem] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        return storage [bucket] != null && storage [bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */