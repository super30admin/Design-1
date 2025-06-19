// Time Complexity : O(1) for add, remove, and contains operations on average
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced minor syntax issues like missing 'new' during array initialization and
//                                           incorrect use of variable case (e.g., 'Bucket' instead of 'bucket'),
//                                           but no logical problems were encountered.


// Your code here along with comments explaining your approach
// Approach:
// Used a 2D boolean array (`boolean[][] storage`) to simulate 10^6 space efficiently.
// Used `key % buckets` and `key / bucketItems` to locate the correct cell for each key.
// Lazily initialized inner arrays only when needed to save memory.


class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000; // Number of buckets
        this.bucketItems = 1000; // Number of items in each bucket
        this.storage = new boolean[buckets][];
    }

    public int getBucket(int key) {
        return key % buckets; // Determine the bucket index using modulo operation
    }

    public int getBucketItem(int key) {
        return key / bucketItems; // Determine the item index within the bucket
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (storage[bucket] == null) {
            // Special case for bucket 0 to handle key = 10^6, which maps to bucket = 0 and bucketItem = 1000 (needs index 0–1000)
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems]; // Initialize the bucket with the size of bucketItems
            }
        }
        storage[bucket][bucketItem] = true; // Set the item to true to add it
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (storage[bucket] == null) {
            return; // If the bucket is empty, nothing to remove
        }
        storage[bucket][bucketItem] = false; // Set the item to false to remove it
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (storage[bucket] == null) {
            return false; // If the bucket is empty, the key is not present
        }
        return storage[bucket][bucketItem]; // Return true if the item exists, false otherwise
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */