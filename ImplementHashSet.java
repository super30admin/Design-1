/*
// Time Complexity : O(1)
// Space Complexity : No additional memory in user defined functions. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

We are using double hashing collision handling technique here assuming we have no constraint on contiguous memory allocation. 
*/

class MyHashSet {

    int primaryBucket;
    int secondaryBucket;
    boolean[][] storage;

    // called only once
    public MyHashSet() {
        //balanace distribution of primary and secondary bucket
        this.primaryBucket = 1000;
        this.secondaryBucket = 1000;

        //we will add secondary array whenever required
        this.storage = new boolean[primaryBucket][]; 
    }
    // 
    private int getPrimaryHash(int key){
        return key % primaryBucket;
    }

    private int getSecondaryHash(int key){
        // double hashing: division to allocate elements in the secondary bucket
        return key / secondaryBucket;
    }

    //TC: O(1)
    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        //check if the reference is created or not
        if(storage[primaryIndex] == null){
            if(primaryIndex == 0){
                // 10^6 % 1000 = 0 hence on 0th index we will have to set the 1000th index
                storage[primaryIndex] = new boolean[secondaryBucket+1];
            }
            else 
                storage[primaryIndex] = new boolean[secondaryBucket];
        }
        // if reference is already created, calculate secondary index and set it to true;
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    //TC: O(1)
    public void remove(int key) {
        // if no reference at primaryIndex, then nothing to remove, else get the secondary index and set it to false
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null)
            return;

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    //TC: O(1)
    public boolean contains(int key) {
        // if no reference at primaryIndex, then return false, else get the secondary index and return 
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null)
            return false;
        
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */