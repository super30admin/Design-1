// Time Complexity : Asymtomatic O(1) for add, remove, contains 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    int buckets;
    int bucketItems;
    boolean storage [][]; 
    
    int getBucket(int key){
        return key %buckets; //hash1 to get primary array index
    }
    
    int getBucketItems(int key){
        return key /bucketItems; //hash2 to get secondary array index 
    }
    
    public MyHashSet() {
        buckets=1000; //total size is 10^6 so we'll design 2d array of 1000*1000
        bucketItems=1001;
        storage= new boolean[buckets][]; //Initialize 2d array of size 1000 with reference default value of null 
    }
    
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItems(key);
        if(storage [bucket]==null){
            storage[bucket]=new boolean[bucketItems]; //creates new secondary array if it is uninitialized
        }
        storage[bucket][bucketItem]=true; //sets to true where val is to be added 
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItems(key);
        if(storage[bucket]==null){ 
            return; // return as it is null
        }
        storage[bucket][bucketItem]=false; //set to false to indicate no val present
    }
    
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItems(key);
        if(storage[bucket]==null){
            return false; //return false as it val not present
        }
        return storage[bucket][bucketItem]; //returns true as val is present 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */