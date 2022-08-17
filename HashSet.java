// Time Complexity : O(1)
// Space Complexity : O(1) - based on given data and worst case if all 1M values are given in data set then O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    int buckets;
    int bucketItems;
    boolean [][] storage;

    public MyHashSet() {
        this.buckets= 1000;
        this.bucketItems=1000;
        this.storage = new boolean [buckets][];
    }

    public int hash1 (int key)
    {
        return key % buckets;
    }

    public int hash2(int key)
    {
        return key / bucketItems;
    }

    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null){
            if (hash1 == 0) {
                storage[hash1] = new boolean[bucketItems + 1];
            }
            else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null)
            return;
        storage[hash1][hash2] = false;
    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null)
            return false;
        else return storage[hash1][hash2]; //returns true since the value is present in location[hash1][hash2]
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */