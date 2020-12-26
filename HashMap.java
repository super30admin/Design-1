// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : It passed the "Run Code" but when I pressed submit it did not work.
// Any problem you faced while coding this : not really.


// Your code here along with comments explaining your approach

class MyHashMap {
    private int [][] storage;
    private int buckets;
    private int bucketItems;
        
    private int bucket(int key){
        return key%buckets;
    }
    
    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1001;
        storage = new int [buckets][];     
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null ){
            storage[bucket] = new int [bucketItems];
        }
        storage[bucket][bucketItem] = value; 
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return -1;
        return storage[bucket][bucketItem];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


