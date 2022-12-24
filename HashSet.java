// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: We create nested arrays. Each element in primary array will have a pointer 
// to its own secondary array. 
// We need to have 2 hashing functions, to avoid collisions.
// You store these arrays in a boolean storage, we need boolean since we have the condition
// 'contains', to check if the value exists or not


class MyHashSet {
    
    //initial storage
    private boolean[][] storage; 
    private int buckets; // primary array
    private int bucketItems; // secondary array
    
    public MyHashSet() {
        this.buckets=1000; //size
        this.bucketItems=1000; //size
        //only initiate primary arr
        this.storage=new boolean[1000][]; 
    }
    
    // Create 2 hash functions
    private int hash1(int key){
        return key%buckets; // returns index of primary array
    }
    private int hash2(int key){
        return key/bucketItems;  //reutrns index of secondary array
    }
    
    public void add(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        
        if(storage[bucket]==null){ // if at that bucket there is a nested array
            if(bucket==0){ //first bucket
                
                storage[bucket]=new boolean[bucketItems+1]; // to prevent index 1000 out of bounds for length  1000
            } else{
                storage[bucket]=new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]=false;
        
    }
    
    public boolean contains(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
         if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }
}