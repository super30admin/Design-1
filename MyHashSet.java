// We use double hashing here. We split our storage into 1000 buckets with 1000 bucket items per bucket. The first hash function is to get the index of the bucket and the second hashing function is to get the index of the bucket item. Double hashing allows us to have O(1) for search

class MyHashSet {
    
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    // O(1)
    private int hash1(int key) {
        return key % buckets;
    }
    
    // O(1)
    private int hash2(int key) {
        return key / bucketItems;
    }
    
    // O(1)
    public void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (storage[h1] == null) {
            storage[h1] = h1 == 0 ? new boolean[bucketItems + 1] : new boolean[bucketItems];
        }
        storage[h1][h2] = true;
    }
    
    // O(1)
    public void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (storage[h1] != null) {
            storage[h1][h2] = false;
        }
    }
    
    // O(1)
    public boolean contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (storage[h1] != null) {
            return storage[h1][h2];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */