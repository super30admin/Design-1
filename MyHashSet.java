// Time Complexity : O(1)
// Space Complexity : O(k), where k is the max key range. ie: O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Description:
// - Use a 2D boolean array where the first hash selects a bucket and the second hash selects an index within that bucket.
// - Allocate sub-buckets lazily to avoid creating space for all possible keys upfront.

class MyHashSet {

    private static final int BUCKET_SIZE = 1000;
    private static final int SUB_BUCKET_SIZE = 1000;

    private final boolean[][] buckets;

    public MyHashSet() {
        this.buckets = new boolean[this.BUCKET_SIZE][];
    }

    public void add(int key) {
        int hash1 = hash1(key);
        if(buckets[hash1] == null) {
            int subBucketSize = this.SUB_BUCKET_SIZE;
            if(hash1 == 0) {
                subBucketSize += 1;
            }
            buckets[hash1] = new boolean[subBucketSize];
        }
        int hash2 = hash2(key);
        buckets[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = hash1(key);
        if(buckets[hash1] == null) {
            return;
        }
        int hash2 = hash2(key);

        buckets[hash1][hash2] = false;
    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        if(buckets[hash1] == null) {
            return false;
        }

        int hash2 = hash2(key);

        return buckets[hash1][hash2];
    }

    private int hash1(int key) {
        return key % this.BUCKET_SIZE;
    }

    private int hash2(int key) {
        return key / this.BUCKET_SIZE;
    }
}