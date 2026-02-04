// O(1) time, O(1) space

class MyHashSet {

    boolean[][] storage;
    int primaryBuckets;
    int secondaryBuckets;

    public MyHashSet() {
        primaryBuckets = 1000;
        secondaryBuckets = 1000;
        storage = new boolean[primaryBuckets][];
    }
    
    private int getPrimaryHash(int key) {
        return key % primaryBuckets;
    }

    private int getSecondaryHash(int key) {
        return key / secondaryBuckets;
    }

    public void add(int key) {
        int primaryHash = getPrimaryHash(key);
        if (storage[primaryHash] == null) {
            if (primaryHash == 0) {
                storage[primaryHash] = new boolean[secondaryBuckets + 1];
            }
            else {
                storage[primaryHash] = new boolean[secondaryBuckets];
            }
        }
        int secondaryHash = getSecondaryHash(key);
        storage[primaryHash][secondaryHash] = true;
    }
    
    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if (storage[primaryHash] == null) {
            return;
        }
        int secondaryHash = getSecondaryHash(key);
        storage[primaryHash][secondaryHash] = false;
    }
    
    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        if (storage[primaryHash] == null) {
            return false;
        }
        int secondaryHash = getSecondaryHash(key);
        return storage[primaryHash][secondaryHash];
    }
}
