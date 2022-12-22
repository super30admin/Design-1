// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach : For this problem we will create array in array. The primary array will have the index corresponding to the first hash function.
// and the nested array which will be boolean will have index corresponding to the second hash function. hash functions will be such that it will avoid all the collisions.
//at the 0 index of primary array we store nested array of 1001 instead of 1000 to accomodate 10^6. To add a value we make the value true and to remove we make it false. 
//To check contains we return the value at that index.

class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.storage = new boolean[1000][];
        this.buckets = 1000;
        this.bucketItems = 1000;        
    }
    
    public int hash1(int key){
        return key%buckets;
    }
    public int hash2(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1]; 
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) return false;
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