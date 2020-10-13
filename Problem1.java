// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was trying to solve this with Time complexity O(1), but the issue is 
//1. After initializing the bucketItems inside buckets all the default values for the inside array are 0
//2. But 0 can be an input 
//3. So to change the default value from 0 to -1, I have to use a for-loop for that perticular column (1000 iterations)
//4. And this is costing me time complexity of O(n)


// Your code here along with comments explaining your approach
class MyHashMap {

    //declare 2d array
    int hmap[][];
    //row size`
    int buckets;
    //column size
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashMap() {
        //bucket size >= square root of input size
        buckets = 1001;
        bucketItems = 1000;
        hmap = new int[buckets][];
    }
    
    //Double hashing technique
    //hash function 1
    public int hash1(int key){
        //1st hash function
        return key % 1000;
    }

    //hash function 2
    public int hash2(int key){
        //2nd hash function
        return key / 1000;
    }
    
    //function used to set the default values for a column to -1
    public void setDefault(int index1){
        for(int i=0; i<bucketItems; i++){
            hmap[index1][i] = -1;
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //calculate indexes using above 2 hashing functions
        int index1 = hash1(key);
        int index2 = hash2(key);
        //if index is null, then only initialise the inner array
        if(hmap[index1] == null){
            hmap[index1] = new int[bucketItems];
            //set default values to -1
            setDefault(index1);
        }
        //set the value at index
        hmap[index1][index2] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //calculate indexes using above 2 hashing functions
        int index1 = hash1(key);
        int index2 = hash2(key);
        //if value not found return -1
        if(hmap[index1] == null || hmap[index1][index2] == -1){
            return -1;
        }
        //return the value
        return hmap[index1][index2];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        //if value not found return and dont do anything
         if(hmap[index1] == null || hmap[index1][index2] == -1){
            return;
        }
        //se the value to -1
        hmap[index1][index2] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */