/*
Author: Akhilesh Borgaonkar
Approach: I have implemented using arrays and double hashing method to avoid collisions. The value is stored at the index key of the sub-array 
    which is nested in the parent array. I have two hashing functions, one generates index for parent array and another generates index for sub-array.
Time Complexity: O(1) for get(), put() and remove()
Space Complexity: O(n) where n is number of elements in the array.
LC verified
*/


class MyHashMap {
    int buckets = 1000;
    int bucketItems = 1000;
    Integer[][] myHashmap = new Integer[buckets][]; //my storage for values at key index

    public MyHashMap() {
        
    }
    
    private int getBucketIdx(int key){      //hashing function-1 to get index of parent array
        return key%buckets;
    }
    
    private int getBucketItemIdx(int key){  //hashing function-2 to get index of sub array
        return key/buckets;
    }
    
    public void put(int key, int value) {
        int bucketIdx = getBucketIdx(key);          //getting the index of parent array
        int bucketItemIdx = getBucketItemIdx(key);  //getting the index of sub array
        
        if(myHashmap[bucketIdx] == null)
            myHashmap[bucketIdx] = new Integer[bucketItems];    //if the sub-array is never created then create it
        
        myHashmap[bucketIdx][bucketItemIdx] = value;    //adding the value to my hashmap
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketIdx = getBucketIdx(key);
        int bucketItemIdx = getBucketItemIdx(key);
        
        if(myHashmap[bucketIdx] != null && myHashmap[bucketIdx][bucketItemIdx] != null)
            return myHashmap[bucketIdx][bucketItemIdx];     //if the index location is non-null and valid then return the value at that location
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketIdx = getBucketIdx(key);
        int bucketItemIdx = getBucketItemIdx(key);
        
        if(myHashmap[bucketIdx] != null && myHashmap[bucketIdx][bucketItemIdx] != null)
            myHashmap[bucketIdx][bucketItemIdx] = null;     //finding the index of parent and sub array and then removing the value
    }
}