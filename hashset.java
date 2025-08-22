// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this : None

class MyHashSet {
    int pBuckets;
    int sBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.pBuckets = 1000;
        this.sBuckets = 1000;
        this.storage = new boolean[pBuckets][];
    }

    private int getPrimaryHash(int key){
        return key % pBuckets;
    }

    private int getSecondaryHash(int key){
        return key / sBuckets;
    }


    public void add(int key) {
        int pIndex = getPrimaryHash(key);
        if (storage[pIndex] == null) {
            if (pIndex == 0) {
                storage[pIndex] = new boolean[sBuckets + 1];
            } else {
                storage[pIndex] = new boolean[sBuckets];
            }
        }

        int sIndex = getSecondaryHash(key);
        storage[pIndex][sIndex] = true;
    }

    public void remove(int key) {
        int pIndex = getPrimaryHash(key);
        if (storage[pIndex] == null) {
            return;
        }
        int sIdex = getSecondaryHash(key);
        storage[pIndex][sIdex] = false;
    }

    public boolean contains(int key) {
        int pIndex = getPrimaryHash(key);
        if(storage[pIndex] == null){
            return false;
        }
        int sIndex = getSecondaryHash(key);
        return storage[pIndex][sIndex];
    }
}