// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MyHashSet {
    //2D array
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
        
    }
    //gets the bucket using first hashing function: key%buckets
    private int getBucket(int key){
        return key%buckets;
    }
    //gets the bucketItem using second hashing function: key/bucketItems
    private int getBucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket= getBucket(key);
        int bucketItem= getBucketItem(key);
        //if there is no bucket item for bucket then create one
        if(storage[bucket]==null){
            // for the 0th bucket create bucket items of size 1001, taking 1000 into consideration
            if(bucket==0)
            {
                storage[bucket]=new boolean[bucketItems+1];
            }
            else{
                storage[bucket]=new boolean[bucketItems];
            }
        }
        // we are no adding the key but adding a boolean value to save space
        storage[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket= getBucket(key);
        int bucketItem= getBucketItem(key);
        if(storage[bucket]==null){
            return;
        }
        //we can make the remove possible by just setting the value to false
        storage[bucket][bucketItem]=false;
        
    }
    
    public boolean contains(int key) {
        int bucket= getBucket(key);
        int bucketItem= getBucketItem(key);
        //if bucket doesnot contain bucket item that means that particular bucket has no values stored
        if(storage[bucket]==null){
            return false;
        }
        //return true or false if there is an item
        return storage[bucket][bucketItem];
    }
}