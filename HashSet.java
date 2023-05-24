//Using Double Hashing
//Time Complexity : O(1)
//Space Complexity : O(n2)

class MyHashSet {
    private int buckets;
    private int bucketItems;
    private boolean storage[][];

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
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
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
            return;
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];
    }
}