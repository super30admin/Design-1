// Time Complexity : O(1)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initally only 26/36 testcases passed. was able to pass all test cases
//after initializing all inner array values to -1.

class MyHashMap {

    private int[][] hashMapStorage;
    private int bucket;
    private int bucketItems;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = 1000;
        bucketItems = 1000;
        hashMapStorage = new int[bucket][];
    }
    
    /** value will always be non-negative. */
    
    public void put(int key, int value) {
        
        if(hashMapStorage[key%bucket] == null) {    //if outer array index is null, add inner array
            if(key%bucket==0)                       //handle ArrayIndexOutOfBound at inner array index 1000
                 hashMapStorage[key%bucket] = new int[bucketItems+1];
            else
              hashMapStorage[key%bucket] = new int[bucketItems]; 
            Arrays.fill(hashMapStorage[key%bucket], -1);  // Intialize all inner array values to negative integer
        }
        hashMapStorage[key%bucket][key/bucketItems] = value;  
        }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(hashMapStorage[key%bucket] == null) { //check corresponding hash value index in outer array
            return -1;
        }
        else if(hashMapStorage[key%bucket][key/bucketItems] < 0) return -1; //check if corresponding value removed in inner array.
        else return hashMapStorage[key%bucket][key/bucketItems];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(hashMapStorage[key%bucket]==null) return;
        hashMapStorage[key%bucket][key/bucketItems] = -1; //make corresponding value as negative integer -1
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */