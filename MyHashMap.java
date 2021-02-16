// Time Complexity : O(1) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Followed similar approach as used in Hashset. Using LinkedList concept to be cleared in future classes. 


// Your code here along with comments explaining your approach
// Used double hashing technique here with a 2-d array
//we use two hash functions here for both inner array and outer array


class MyHashMap {

    /** Initialize your data structure here. */
    //Hashmap using double hashing
    private int[][] map;
    private int buckets;
    private int bucketItems;
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1001;
        map = new int [buckets][];
    }
    
    //hash function for the outer array
    public int bucketHash(int key)
    {
        return key % buckets;
    }
    //hash fuction for the inner array
    public int bucketItemHash(int key)
    {
        return key / bucketItems;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        
        if(map[bucket]==null)
        {
            map[bucket] = new int [bucketItems];
        }
        map[bucket][bucketItem] = value +1;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        
        return map[bucket]!=null&&map[bucket][bucketItem]!=-1 ? map[bucket][bucketItem] -1: -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int bucket = bucketHash(key);
        int bucketItem = bucketItemHash(key);
        if(map[bucket]!=null)
        {
            map[bucket][bucketItem] =-1;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */