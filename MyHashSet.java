//Time Complexity = O(n)
//Space Complexity =O(1)
/*First formed the logical relation between the nodes or buckets with the item that are bucketitems.we refer bucket as the individual indexes of the array and bucketitem as the value which gets stored in the arrays.
Considered 2 main hashing functions to calculate the key for buckets and bucketitems. We considered mod and division operator to calculate the key of the bucket and bucketitems respectively. we use boolean array because it consumes less space then integer array If there is new insertion then we just add it to the bucket. Or else if present then we add to the item that is present in the bucket. For remove no item present then return null, and if present then make the value as false. For contains we just check whether the item is present or not */
//Ran on leetcode

class MyHashSet {
    boolean[][] storage;
    int buckets,bucketItems;
   
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    public int getBucket(int key){
        return key % buckets;
    }
    public int getBucketItem(int key){
        return key / bucketItems;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            if(bucket == 0){
                storage[bucket]= new boolean[bucketItems+1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null) return;
        else{
            storage[bucket][bucketItem]= false;
        }

        
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null) return false;
        
      
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