// Time Complexity : O(1)
// Space Complexity : O(1) for user functions and O(n) for constructor
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
Maintain primary and secondary arrays by hashing with modulo and divide operations to store, remove
and check if it contains or not. We leverage primary and secondary hashes by computing the respective
key with that bucket size and operation.
 */
class MyHashSet {
    boolean[][] arr;
    int primaryBuckets;
    int secondaryBuckets;

    public MyHashSet() {
        this.primaryBuckets = 1001;
        this.secondaryBuckets = 1000;
        this.arr = new boolean[primaryBuckets][];
    }

    private int getPrimaryHash(int key) {
        return key / primaryBuckets;
    }

    private int getSecondaryHash(int key) {
        return key % secondaryBuckets;
    }

    public void add(int key) {
        int primaryHash = getPrimaryHash(key);
        if(arr[primaryHash] == null) {
            arr[primaryHash] = new boolean[secondaryBuckets];
        }
        int secondaryHash = getSecondaryHash(key);
        arr[primaryHash][secondaryHash] = true;
    }

    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if(arr[primaryHash] == null) {
            return;
        }
        int secondaryHash = getSecondaryHash(key);
        arr[primaryHash][secondaryHash] = false;
    }

    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        if(arr[primaryHash] == null) {
            return false;
        }
        int secondaryHash = getSecondaryHash(key);
        return arr[primaryHash][secondaryHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */