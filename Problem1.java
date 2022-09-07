// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    // Using double hashing technique to solve this problem
    boolean[][] storage;
    int bucketSize;
    int bucketItemSize;

    public MyHashSet() {
        bucketSize = 1000;
        bucketItemSize = 1000;
        storage = new boolean[bucketSize][];
    }

    // First hashing function to determine the index position in primary array
    public int getBucket(int key) {
        return key % bucketSize;
    }

    // Second hashing function to determine the index position in secondary array
    public int getBucketItem(int key) {
        return key / bucketItemSize;
    }

    public void add(int key) {
        // get bucket
        int bucket = getBucket(key);
        // get bucketItem
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null) {
            // to address the edge case of 10^6 we need to increase the size of sec array by 1 at 0th pos of primary array
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItemSize + 1];
            }
            else {
                // Initialize the determined index position in primary array with new array of size bucketItem (secondary array)
                storage[bucket] = new boolean[bucketItemSize];
            }
        }

        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        // get bucket
        int bucket = getBucket(key);
        // get bucketItem
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null)
            return;

        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        // get bucket
        int bucket = getBucket(key);
        // get bucketItem
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null)
            return false;

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