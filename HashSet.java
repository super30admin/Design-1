// here we used Technique of Double Hashing, there methods such as LL,BBST,       Linear probing
class MyHashSet {

    int buckets,bucketItems;
    boolean[][] storage;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];    // initialize column array only when it's necessary as seen below   
    }
    
    int getBucket(int key) {
        return key % buckets;
    }
    
    int getBucketItem(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {   // means it's empty hence we can store/add the element
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1]; // this is to handle the edge case of when key is of value 10^6 then 10^6 % 10^3 is 0 and  10^6 / 10^3 is 10^3 but we have only 0 - 999 array positions 
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;       
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return false;
        }
        
        return storage[bucket][bucketItem];
        
    }
}