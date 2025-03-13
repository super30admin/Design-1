// Explaination
// Here we are using double hashing to determine buckets and items per buckets
// getBucketIndex determines the primary array index
// getItemIndex determines the index inside secondary array
// Since the range of N is 10^6 thus size of buckets and items per bucket is 1000 * 1000 by taking square root of N

// Time Complexity
// All operations: O(1)
// Space Complexity
// O(N) as we can store all the N numbers inside Hashset
class MyHashSet {

    private boolean[][] storage;
    private static final int BUCKETS = 1000;
    private static final int ITEMS_PER_BUCKET = 1000;

    public MyHashSet() {
        storage = new boolean[BUCKETS][];
    }

    private int getBucketIndex(int key) {
        return key % BUCKETS;
    }

    private int getItemIndex(int key) {
        return key / ITEMS_PER_BUCKET;
    }

    private void ensureBucketExists(int bucketIndex) {
        if (storage[bucketIndex] == null) {
            storage[bucketIndex] = new boolean[bucketIndex == 0 ? ITEMS_PER_BUCKET + 1 : ITEMS_PER_BUCKET];
        }
    }

    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        int itemIndex = getItemIndex(key);
        ensureBucketExists(bucketIndex);
        storage[bucketIndex][itemIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int itemIndex = getItemIndex(key);
        if (storage[bucketIndex] != null) {
            storage[bucketIndex][itemIndex] = false;
        }
    }

    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        int itemIndex = getItemIndex(key);
        return storage[bucketIndex] != null && storage[bucketIndex][itemIndex];
    }
}
