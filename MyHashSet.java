// Time Complexity : O(1) for all methods
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    
    int buckets;
    int bucketItems;
    
    // 2D array to store the hashSet keys
    boolean[][] storage;
    

    public MyHashSet() {   
        // Define the size of the buckets
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    // First hash function
    private int getBucket(int key){
        return key % buckets;
    }
    
    // Second hash function
    private int getBucketItems(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        // Get the hash values
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        
        //Initialise a 1D array if it is not present
        if(storage[bucket] == null){
            // To accomodate the upper bound 10 ^ 6
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        // Add the element to the respective index
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        // Get the hash values
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        
        // If the 1D is not been initialised, return
        if(storage[bucket] == null){
            return;
        }
        
        // Remove the element
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        // Get the hash values
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        
        // If the 1D is not been initialised, return false
        if(storage[bucket] == null){
            return false;
        }
        
        // Return if the element exists or not
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
