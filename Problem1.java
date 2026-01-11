// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/* we are implementing HashSet which is 1D boolean array with primary and secondary hashing to store keys. 
we have followed double hashing technique to avoid collisions.
add, remove, and contains operations ad implemented with O(1) time complexity.
time - O(1)
space - O(n)*/

class MyHashSet {

    //length of primary and nested arrs
    private int buckets;
    private int bucketItems;
    private boolean [][]storage;
    
    //primary bucket
    private int hash1(int key){
        return key%buckets;
    }

    //nested array bucket
    private int hash2(int key){
        return key/bucketItems;
    }

    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        this.storage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = hash1(key);
        //check for nested array
        if(storage[bucket]==null){
            //only for 0 element edge case to set 1000000 value
            if(bucket==0){
            storage[bucket]= new boolean[bucketItems +1];
        }
        else{
            storage[bucket]=new boolean[bucketItems];
        }
    }
    int bucketItem = hash2(key);
    storage[bucket][bucketItem]=true;    
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        //check for nested array
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]=false;
    }

    public boolean contains(int key) {
        int bucket =hash1(key);
        int bucketItem = hash2(key);
        //check for nested array
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}