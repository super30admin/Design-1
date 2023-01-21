// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


//Our aim is search in O(1) to achieve we are using 2D array with primary array  pointer to a secondary boolean array
//we are using 2 hash functions to get the index of the primary and secondary array to avoid collision


class MyHashSet {
    int primaryArray;
    int secondaryArray;
    private boolean[][] storage;

    public MyHashSet() {
        this.primaryArray = 1000;
        this.secondaryArray = 1000;
        this.storage = new boolean[primaryArray][];
    }

    private int pHash(int key) {
        return key % 1000;
    }

    private int sHash(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int pIndex = pHash(key);
        int sIndex = sHash(key);
        if (storage[pIndex] == null) {
            if (pIndex == 0) {
                //speacial case for stroing the last value in the array
                storage[pIndex] = new boolean[secondaryArray + 1];
            } else
                storage[pIndex] = new boolean[secondaryArray];
        }

        storage[pIndex][sIndex] = true;

    }

    public void remove(int key) {
        int pIndex = pHash(key);
        int sIndex = sHash(key);
        if (storage[pIndex] == null)
            return;
        else
            storage[pIndex][sIndex] = false;

    }

    public boolean contains(int key) {
        int pIndex = pHash(key);
        int sIndex = sHash(key);
        if (storage[pIndex] == null)
            return false;
        else
            return storage[pIndex][sIndex];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */