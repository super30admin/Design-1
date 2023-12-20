class MyHashSet {
    private boolean [][]storage;
    int primaryBucketItem;
    int secondaryBucketItems;
    public MyHashSet() {
        this.primaryBucketItem = 1000;
        this.secondaryBucketItems = 1000;
        this.storage = new boolean[primaryBucketItem][];
    }
    
    private int primaryIndex(int key) {
        return key % this.primaryBucketItem;
    }

    private int secondaryIndex(int key) {
        return key / this.secondaryBucketItems;
    }

    public void add(int key) {
        int primaryIndex = primaryIndex(key);
        int secondaryIndex = secondaryIndex(key);
        if (storage[primaryIndex] == null) {
            if (primaryIndex == 0) {
                storage[primaryIndex] = new boolean[secondaryBucketItems + 1];
            } else {
                storage[primaryIndex] = new boolean[secondaryBucketItems];
            }
        }
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = primaryIndex(key);
        int secondaryIndex = secondaryIndex(key);
        if (storage[primaryIndex] != null) {
            storage[primaryIndex][secondaryIndex] = false;
        }
    }
    
    public boolean contains(int key) {
        int primaryIndex = primaryIndex(key);
        int secondaryIndex = secondaryIndex(key);
        if (storage[primaryIndex] == null) return false;
        return storage[primaryIndex][secondaryIndex];
    }
}
