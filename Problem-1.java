/* To design my hash set I've used Double Hashing collision handling technique. */

class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][];
    }

    private int getPrimaryHash(int key)
    {
        return key % primaryBuckets;
    }

    private int getSecondaryHash(int key)
    {
        return key / secondaryBuckets;
    }
    
    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null)
        {
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secondaryBuckets+1];
            }
            else{
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */