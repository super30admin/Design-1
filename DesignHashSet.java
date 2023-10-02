/* Time Complexity : 
 * each of add, remove, contains - O(1)*/
/* Space Complexity : 
 * each of add, remove, contains - O(1)*/
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashSet {

    private boolean[][] storage;
    private int buckets; //primary array
    private int bucketItems; //secondary array

    //to get index of key present under which bucket in primary array
    private int hash1(int key){
        return key%1000;
    }

    //to get index of key in the secondary array
    private int hash2(int key){
        return key/1000;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[1000][];        
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        //If secondary array is not present
        if(storage[bucket] == null){
            //At the first index create a secondary array of length bucketItems + 1 (to store the value of 10^6)
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }else{//create a secondary array of length bucketItems
                storage[bucket] = new boolean[bucketItems];
            }
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        //If primary array/bucket is null ==> the key is not present
        if(storage[bucket] == null) return;
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        //If primary array/bucket is null ==> the key is not present
        if(storage[bucket] == null) return false;
        int bucketItem = hash2(key);
        return storage[bucket][bucketItem];
    }
}
