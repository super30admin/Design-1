// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Used 2 hashed functions one for mod and one as divide. Used that function to create 2 dimensinal array as required. According to the hashed value the number are added to specific locations.

class MyHashSet {

    boolean[][] myStore;
    int buckets = 1000;
    int bucketItems = 1000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        myStore = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (myStore[bucket] == null) {
            myStore[bucket] = new boolean[bucketItems];
        }
        myStore[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (myStore[bucket] != null) {
            myStore[bucket][bucketItem] = false;
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        return myStore[bucket] != null && myStore[bucket][bucketItem] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */