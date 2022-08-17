// Time Complexity : O(1) for all functions
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;

    public HashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key) {
        return key/bucketItems;
    }

    public void add(int key) {
        int hash1val = hash1(key);
        int hash2val = hash2(key);
        if (storage[hash1val] == null) {
            if(hash1val == 0){
                storage[hash1val] = new boolean[bucketItems+1];
            }
            else{
                storage[hash1val] = new boolean[bucketItems];
            }
        }
        storage[hash1val][hash2val] = true;
    }

    public void remove(int key) {
        int hash1val = hash1(key);
        int hash2val = hash2(key);
        if (storage[hash1val] == null) return;
        storage[hash1val][hash2val] = false;
    }

    public boolean contains(int key) {
        int hash1val = hash1(key);
        int hash2val = hash2(key);
        if (storage[hash1val] == null) return false;
        return storage[hash1val][hash2val];
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */