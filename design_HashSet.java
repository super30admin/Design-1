//TC: O(1)
//SC: range of the nos. O(n)
//using double hashing

class MyHashSet {
    
    private boolean [] [] storage;
    int horizontalBuckets;
    int verticalBucketItems;

    public int horizontalBucket(int key){
        return key%horizontalBuckets;
    }

    public int verticalBucketItem(int key){
        return key/horizontalBuckets;
    }


    public MyHashSet() {  //O(n^2)
        this.horizontalBuckets = 1000;
        this.verticalBucketItems = 1000;
        this.storage = new boolean[horizontalBuckets][];
        
    }
    
    public void add(int key) { //O(1)
        int bucket = horizontalBucket(key);
        int bucketItem = verticalBucketItem(key);
        
        if(storage[bucket]==null){
            if(bucket == 0){
                storage[bucket] = new boolean[verticalBucketItems + 1]; //edge case to handle last element as 1000000/1000=0, we need extra space at the end
            }else{
                storage[bucket] = new boolean[verticalBucketItems];
            } 
        }
        
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {  //O(n)
        int bucket = horizontalBucket(key);
        int bucketItem = verticalBucketItem(key);
        
        if(storage[bucket] != null){
             storage[bucket][bucketItem] = false;
        }            
    }
    
    public boolean contains(int key) {  //O(1)
        int bucket = horizontalBucket(key);
        int bucketItem = verticalBucketItem(key);
        
         return storage[bucket] != null && storage[bucket][bucketItem];
        
    }
}
