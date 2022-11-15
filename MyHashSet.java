// Time Complexity : o(1)
// Space Complexity :o(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] stored;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        stored = new boolean[buckets][];

    }

    int getBucket(int key) {
        return key % buckets;
    }

    int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (stored[bucket] == null) {
            if (bucket == 0) {
                stored[bucket] = new boolean[bucketItems + 1];
            } else {
                stored[bucket] = new boolean[bucketItems];
            }
        }
        stored[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (stored[bucket] == null)
            return;
        stored[bucket][bucketItem] = false;
        return;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (stored[bucket] == null)
            return false;
        return stored[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */