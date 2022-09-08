
// Time Complexity : O(1) // Add, Remove, Contains
// Space Complexity : O(n) // Worst case

class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    //Get index of bucket from Primary Array 
    private int getBucketIndex(int key){
        return key % buckets;
    }
    
    //Get index of bucket item from secondary Array 
    private int getBucketItemIndex(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        
        if(storage[bucketIndex] == null){
            if(bucketIndex == 0){
                storage[bucketIndex] = new boolean[bucketItems + 1];
            }
            else{
                storage[bucketIndex] = new boolean[bucketItems];
            }
        }
		storage[bucketIndex][bucketItemIndex] = true;
    }
    
    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        
        if(storage[bucketIndex] == null){
            return;
        }
        
        storage[bucketIndex][bucketItemIndex] = false;
    }
    
    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        
        if(storage[bucketIndex] == null){
            return false;
        }
        
        return storage[bucketIndex][bucketItemIndex];
    }
}