class HashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int getBucketsHash(int k) {
        return k % buckets;
    }

    private int getBucketItemsHash(int k) {
        return k / bucketItems;
    }

    public void add(int key) {
        int bucketHash = getBucketsHash(key);
        int bucketItemsHash = getBucketItemsHash(key);
        if (storage[bucketHash] == null) {
            if (bucketHash == 0) {
                storage[bucketHash] = new boolean[bucketItems + 1];
            } else {
                storage[bucketHash] = new boolean[bucketItems];
            }
        }
        storage[bucketHash][bucketItemsHash] = true;
    }

    public void remove(int key) {
        int bucketHash = getBucketsHash(key);
        int bucketItemsHash = getBucketItemsHash(key);
        if (storage[bucketHash] == null) {
            return;
        }
        storage[bucketHash][bucketItemsHash] = false;
    }

    public boolean contains(int key) {
        int bucketHash = getBucketsHash(key);
        int bucketItemsHash = getBucketItemsHash(key);
        if (storage[bucketHash] == null) {
            return false;
        }
        return storage[bucketHash][bucketItemsHash];
    }
}

/**
 * Your HashSet object will be instantiated and called as such:
 * HashSet obj = new HashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */