// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced issue on how to handle the edge case of handling 10^6 


// Your code here along with comments explaining your approach
//Approach : For this problem we will create array with nested arrays. The primary array will be the pointer corresponding to the first hash function.
// and the nested array will be boolean. Hash functions will be such that it will avoid all the collisions.

class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.storage = new boolean[1000][];
        this.buckets = 1000;
        this.bucketItems = 1000;        
    }

    public int hash1(int key){
        return key%buckets;
    }
    public int hash2(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1]; 
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;

    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.cont