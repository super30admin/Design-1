//Time Complexity - O(1)
//Space Complexity - O(m * n)

// Implemented Hashset by using 2D boolean array and 2-choice hashing.
class HashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public HashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[this.buckets][];
    }

    int getBuckets(int key) {
        return key % 1000;
    }

    int getBucketItems(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
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
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBuckets(key);
        int buckeItem = getBucketItems(key);
        if (storage[bucket] == null){
            return false;
        }
        return storage[bucket][buckeItem];
    }
}