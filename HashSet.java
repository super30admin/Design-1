// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    boolean[][] bucket;
    boolean[] bucketItems;

    private int getBucket(int value) {
        return value % 1000;
    }

    private int getBucketItems(int value) {
        return value / 1000;
    }

    public MyHashSet() {
        bucket = new boolean[1000][];
    }

    public void add(int key) {
        int bucketIdex = getBucket(key);

        // Initialize secondary array
        if(bucket[bucketIdex] == null) {
            if(bucketIdex == 0) {
                bucket[bucketIdex] = new boolean[1000 + 1];
            } else {
                bucket[bucketIdex] = new boolean[1000];
            }
        }
        // Get bucketItems index and set to true
        int BucketItemsIndex = getBucketItems(key);
        bucket[bucketIdex][BucketItemsIndex] = true;
    }

    public void remove(int key) {
        int bucketIdex = getBucket(key);
        int BucketItemsIndex = getBucketItems(key);

        if (bucket[bucketIdex] == null) {
            return;
        }
        if (bucket[bucketIdex][BucketItemsIndex] == true) {
            bucket[bucketIdex][BucketItemsIndex] = false;
        }


    }

    public boolean contains(int key) {
        int bucketIdex = getBucket(key);
        int BucketItemsIndex = getBucketItems(key);
        if (bucket[bucketIdex] == null) {
            return false;
        } else {
            if(bucket[bucketIdex][BucketItemsIndex] == false) {
                return false;
            } else {
                return true;
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */