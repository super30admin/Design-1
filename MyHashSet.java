class MyHashSet {
    int buckets;
    int bucketItems;
    private boolean[][] storage;

    public MyHashSet() {
        this.buckets = 10000;
        this.bucketItems = 10000;
        storage = new boolean[this.buckets][this.bucketItems];
    }

    public int getBucket(int key) {
        return key % this.buckets;
    }

    public int getBucketItem(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[this.bucketItems + 1];
            } else {
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        // just make it false
        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        // look for null , if null return false , else true
        if (storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */