
class MyHashSet {
    private boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public int buckets(int key) {
        return key % buckets;
    }

    public int bucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int buckets = buckets(key);
        int bucketItems = bucketItems(key);
        if (storage[buckets] == null) {
            if (buckets == 0) {
                storage[buckets] = new boolean[bucketItems + 1];
            } else {
                storage[buckets] = new boolean[bucketItems];
            }
        }
        storage[buckets][bucketItems] = true;
    }

    public void remove(int key) {
        int buckets = buckets(key);
        int bucketItems = bucketItems(key);
        if (storage[buckets] == null) {
            return;
        }
        storage[buckets][bucketItems] = false;
    }

    public boolean contains(int key) {
        int buckets = buckets(key);
        int bucketItems = bucketItems(key);
        if (storage[buckets] == null)
            return false;
        return storage[buckets][bucketItems];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */