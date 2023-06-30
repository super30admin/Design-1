class MyHashMap {
    int[][] storage;
    int buckets;
    int bucketItems;

    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new int[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) {
            storage[bucket] = new int[bucketItems];
        }
        storage[bucket][bucketItem] = value;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = -1;
        }
    }

    public int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] != null) {
            return storage[bucket][bucketItem];
        }
        return -1;
    }
}
