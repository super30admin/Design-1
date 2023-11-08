// Time Complexity : add: O(1), remove: O(1), contains: O(1)
// Space Complexity : Best Case: O(1), Worst Case: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use boolean array to keep track of key as it requires only 1 byte of storage space
// We will have array size equal to square root of the total keys allocated initially to optimize memory allocation
// We will create a new inner array on demand only
// For getting outer array index, we will use division hash function and for inner array index, we will use modulo hash function

class MyHashSet {
    private int outerBucketSize;
    private int innerBucketSize;
    private boolean bucket[][];


    public MyHashSet() {
        this.outerBucketSize = 1001;  // size will be square root of the total keys + 1 (for handling 1000000th key)
        this.innerBucketSize = 1000;
        bucket = new boolean[outerBucketSize][];
    }

    private int getOuterKey(int key){
        return key / 1000;
    }

    private int getInnerKey(int key){
        return key % 1000;
    }

    
    public void add(int key) {
        int outerKey = this.getOuterKey(key);
        if(bucket[outerKey] == null){
            bucket[outerKey] = new boolean[innerBucketSize];
        }
        int innerKey = this.getInnerKey(key);
        bucket[outerKey][innerKey] = true;
    }
    
    public void remove(int key) {
        int outerKey = this.getOuterKey(key);
        if(bucket[outerKey] != null){
            int innerKey = this.getInnerKey(key);
            bucket[outerKey][innerKey] = false;
        }
    }
    
    public boolean contains(int key) {
        int outerKey = this.getOuterKey(key);
        if(bucket[outerKey] == null){
            return false;
        }
        int innerKey = this.getInnerKey(key);
        return bucket[outerKey][innerKey];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */