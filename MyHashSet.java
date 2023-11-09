// Time Complexity - add:O(1), remove:O(1), contains:O(1)
// Space Complexity - Best Case: O(1), Worst Case: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Double hashing algorithm is used to find the index in the array.
add() : calculates the inner and outer hashcode, then marks the array index as true.
remove() : calculates the inner and outer hashcode, then marks the array index as false
contains() : calculates the inner and outer hashcode, and returns the value from that index
*/

class MyHashSet {

    int outerBucket;
    int innerBucket;
    boolean[][] hashSet;

    public MyHashSet() {
        // this.outerBucket = 1001;
        this.outerBucket = 1000;
        this.innerBucket = 1000;
        this.hashSet = new boolean[outerBucket][];
    }

    public int getOuterHash(int key) {
        // return key / outerBucket;    
        return key % outerBucket;
    }

    public int getInnerHash(int key) {
        // return key % innerBucket;
        return key / innerBucket;
    }

    public void add(int key) {

        // int outerhash = getOuterHash(key);
        // // if(hashSet[outerhash] == null) {
        // //      hashSet[outerhash] = new boolean[innerBucket];
        // int innerhash = getInnerHash(key);
        // hashSet[outerhash][innerhash] = true;

        int outerhash = getOuterHash(key);

        if(hashSet[outerhash] == null) {
            if(outerhash == 0)
                hashSet[outerhash] = new boolean[innerBucket+1];
            else
                hashSet[outerhash] = new boolean[innerBucket];
        }

        int innerhash = getInnerHash(key);
        hashSet[outerhash][innerhash] = true;

    }

    public void remove(int key) {

        int outerhash = getOuterHash(key);

        if(hashSet[outerhash] != null) {
            int innerhash = getInnerHash(key);
            hashSet[outerhash][innerhash] = false;
        }
    }

    public boolean contains(int key) {

        int outerhash = getOuterHash(key);

        if(hashSet[outerhash] == null)
            return false;

        int innerhash = getInnerHash(key);

        return hashSet[outerhash][innerhash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */