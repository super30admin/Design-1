
// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//HashMap with double hashing

class MyHashMap {
    
    Integer [][] storage;
    int buckets;
    int bucketItems;

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new Integer [buckets][];  
    }
    
    private int hash1(int key){
        return key%buckets;
    }
    
    private int hash2(int key){
        return key/bucketItems;
    }
    
    public void put(int key, int value) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket]==null){
            if(bucket==0){
                storage[bucket]= new Integer[bucketItems+1];
                
            }
            else{
                storage[bucket]= new Integer[bucketItems];
            
            }
        }
        storage[bucket][bucketItem] = value;
        
    }
    
    public int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket]==null){
            return -1;
        }
        if (storage[bucket][bucketItem] !=null ){
            return storage[bucket][bucketItem];
        }
        else{
            return -1;
        }
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=null;
        
    }
}