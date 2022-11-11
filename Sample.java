// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
while running the design hashset problem I'm getting java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 in line 30

// Your code here along with comments explaining your approach
  class MyHashSet {
    boolean[][]storage;
    int buckets, bucketItems;
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[buckets][];
        
    }
    int getBucket(int key){
        return key % buckets;
    }
    
    int getBucketItems(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int buckets = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(storage[buckets] == null){
            if(buckets == 0){
                 storage[buckets] = new boolean[bucketItems + 1];
            }
            else {
                storage[buckets]= new boolean[bucketItems];
            }
        }
        
          storage[buckets][bucketItems] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(storage[buckets]==null){
            return;
        }
        storage[buckets][bucketItems]=false;
    }
    
    public boolean contains(int key) {
        int buckets = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(storage[buckets]==null){
            return false;
        }
        return storage[buckets][bucketItems];      
    }
}
