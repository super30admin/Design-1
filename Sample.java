class MyHashSet {

    private int buckets = 1000;
    private int bucketItems = 1001;
    private boolean[][] storage;

    public MyHashSet() {
        storage = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        return storage[bucket] != null &&
               storage[bucket][bucketItem];
    }
}
