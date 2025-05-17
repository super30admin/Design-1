// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashSet {

    private boolean[][] storage;
    int buckets;
    int bucketItems;    //size

    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int idx1 = hash1(key);
        if(storage[idx1] == null){
            if(idx1 == 0){
                storage[idx1] = new boolean[bucketItems + 1];
            }
            else{
                storage[idx1] = new boolean[bucketItems];
            }
        }
        int idx2 = hash2(key);
        storage[idx1][idx2] = true;
    }
    
    public void remove(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);
        if(storage[idx1] == null)
            return;
        storage[idx1][idx2] = false;
    }
    
    public boolean contains(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);
        if(storage[idx1] == null)
            return false;
        else
            return storage[idx1][idx2];
    }
}
