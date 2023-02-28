class MyHashSet {
	
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];

    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return;
        storage[bucket][bucketItem] = false;
        return;
    }

    int getBucket(int key) {
        return key % buckets;
    }

    int getBucketItem(int key) {
        return key / bucketItems;
    }
}

