// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Use double hashing
class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][]; 
    }

    private int getPrimaryHash(int key){
        return key % primaryBuckets;//finds primary bucket for the key
    }

    private int getSecondaryHash(int key){
        return key / secondaryBuckets;//finds position in primary bucket
    }

    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex == 0){//extra slot for 10^6 key
                storage[primaryIndex] = new boolean[secondaryBuckets+1];
            }else{
                storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }

    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}
