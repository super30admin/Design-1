// Design HashSet
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. But have a doubt. Will ask the TA.


// Approach
// Create a boolean matrix consist of a primary array and a secondary array. Initiate only the primary array
// We have two senario now. If the nested array is present. Else nested array is not there.
// Based on that two condition will write our cases.

class MyHashSet {
    private boolean[][] storage; //boolean matrix
    private int buckets; //primary array
    private int bucketitems; //secondary array(nested)

    public MyHashSet() {
        //initiate the storage size
        this.buckets = 1000;
        this.bucketitems = 1000;
        this.storage = new boolean[buckets][]; //only initiate primary one, not secondary, adv of making a matrix
    }

    private int hash1(int key) {
        return key%buckets;
    }
    private int hash2(int key) {
        return key/bucketitems;
    }


    public void add(int key) {
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        //two senarios, if no nested array & if nestes array is present
        if(storage[bucket] == null) { //primary array:pointer:null
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketitems +1];
            }
            else {
                storage[bucket] = new boolean[bucketitems];
            }
        }
        storage[bucket][bucketitem] = true;
    }


    public void remove(int key) {
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        //if no nested array
        if(storage[bucket] == null) return;
        //if present
        storage[bucket][bucketitem] = false;
    }


    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        if(storage[bucket] == null)
            return false;

        return storage[bucket][bucketitem];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */