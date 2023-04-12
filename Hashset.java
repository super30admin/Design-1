// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/* Approach:
We take help of 2D boolean array to design hashset and double hashing to resolve collision
We take a primary array of length = sqrt(Max key constraint) = sqrt(10^6) = 10^3. We take the first hash function as key%1000
and a secondary array of length 10^3 (keys are evenly distributed) and second hash function as key/1000 to resolve collision
Add, Remove and contains are implemented with constant time
 */


 public class Hashset {
    boolean[][] storage;
    int buckets;  // primary array size
    int bucketItems; // secondary array size

    public Hashset() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    /*
    first hash function
     */
    private int getBucket(int key) {
        return key % buckets;
    }

    /*
    second hash function
     */
    private int getBucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        // if the primary array index is null, we build a secondary array and assign the key to true else we just assign
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1]; // for edge case when key = 10^6, bucketItem should hold index 1000
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if (storage[bucket] != null) {
            // this means the key is there in our secondary array at index = bucketItem
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if (storage[bucket] != null) {
            // blindly return the value at bucketItem
            return storage[bucket][bucketItem];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
