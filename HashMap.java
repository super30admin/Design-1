class MyHashMap {


    int[][] storage;
    int buckets, bucketItems;
    
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }
    
     public int getBucket(int key) {
        return key % 1000;
    }
    
    public int getBucketItem(int key) {
        return key / 1000;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null) {
    
            int newBucketItems = bucket == 0 ? bucketItems + 1 : bucketItems;
            
            storage[bucket] = new int[newBucketItems];

            for(int i = 0; i < newBucketItems; i++) {
                storage[bucket][i] = -1;
            }
        }
        
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null) {
            return -1;
        }
        
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if(storage[bucket] == null) {
            return;
        }
        
        storage[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */