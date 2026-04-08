
// Time Complexity : O(1) for add (amortized), remove and contains
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// this approach uses double hashing to store the keys in a 2D boolean array. 
// The primary hash function determines the index of the first dimension, 
// while the secondary hash function determines the index of the second dimension. 
// This allows us to efficiently store and retrieve keys while minimizing space usage.

class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        primaryBuckets = 1000;
        secondaryBuckets = 1000;
        storage = new boolean[primaryBuckets][];
    }

    int getPrimaryHash(int key){
        return key%primaryBuckets;
    }
    int getSecondaryHash(int key){
        return key/secondaryBuckets;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null){
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secondaryBuckets +1];
            }else{
                storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null){
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }

    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null){
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}