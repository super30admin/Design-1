// Time Complexity : add(),remove(),contains() - O(1) 
// Space Complexity : store elements - O(n) - 10^6 (Worst Case)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Note: I am implementing it after class and I am not sure how I would have done before the class 


// Your code here along with comments explaining your approach

class MyHashSet {
    
    private boolean storage[][];
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        //Initializing values
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
        
    }
    
    //Hash function 1
    private int bucket(int key) {
        return key%buckets;
    }
    
    //Hash function 2
    private int bucketItem(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key); //hash value 1
        int bucketItem = bucketItem(key); //hash value 2
        if(storage[bucket] == null) { //check whether the bucket is intialised or not
            if(bucket == 0) {
                storage[bucket] = new boolean[ bucketItems+1 ]; // to handle 10^6 case
            } else {
                storage[bucket] = new boolean[ bucketItems ]; // all other cases
            }
        }
        storage[bucket][bucketItem] = true; //storing the value
    }
    
    public void remove(int key) {
        int bucket = bucket(key); //hash value 1
        int bucketItem = bucketItem(key); //hash value 2
        if(storage[bucket]==null) { return; } //check whether the bucket is intialised or not
        storage[bucket][bucketItem] = false; //removing the value
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key); //hash value 1
        int bucketItem = bucketItem(key); //hash value 2
        if(storage[bucket]==null) { return false; } //check whether the bucket is intialised or not
        else { return storage[bucket][bucketItem]; } //returns whether the value is present or not
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */