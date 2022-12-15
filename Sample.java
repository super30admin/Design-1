// Time Complexity : O(1)
// Space Complexity : O(n) where n is the buckets 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : i faced problems when i tried to do it in python 


// Your code here along with comments explaining your approach
class MyHashSet {
   boolean[][] storage;
   int buckets,bucketitems;
    
    
    public MyHashSet() {
        buckets = 1000;
        bucketitems = 1000;
        storage = new boolean[buckets][];
        
    }
    // first hash
    int getbucket(int key) {
        return key % buckets;
    }
    
    // second hash
    int getbucketitem(int key) {
        return key / bucketitems;
        }
    
     
    
    
    public void add(int key) {
        int bucket = getbucket(key);
        int bucketitem = getbucketitem(key);
        if (storage[bucket] == null){
            if (bucket == 0){
                storage[bucket] = new boolean [bucketitems+1];
            }
            else{
                 storage[bucket] = new boolean [bucketitems];
            }
           
        }
        storage[bucket][bucketitem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getbucket(key);
        int bucketitem = getbucketitem(key);

        if (storage[bucket] == null){
            return;
        }
        
        storage[bucket][bucketitem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getbucket(key);
        int bucketitem = getbucketitem(key);
        if (storage[bucket] == null ){
            return false;
        }
        return storage[bucket][bucketitem];
        
    }
}
