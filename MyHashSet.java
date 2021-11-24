class MyHashSet {

    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : YEs
    // Any problem you faced while coding this : No

    // Your code here along with comments explaining your approach
    boolean[][] storage;
    int buckets;
    int bucketItems;

    // instantiated 2D boolean array
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    // returns the index of the bucket for a given key
    private int bucketIndex(int key) {
        return key % buckets;
    }

    // returns the index of the secondary array for a given key
    private int bucketItemIndex(int key) {
        return key / buckets;
    }

    // Time Complexity : O(1)

    public void add(int key) {

        int bucket = bucketIndex(key);
        int bucketItem = bucketItemIndex(key);
        // if bucket is null, instantiate the secondary array for the bucket index
        if (storage[bucket] == null) {
            if (bucket == 0)
                storage[bucket] = new boolean[bucketItems + 1];
            else
                storage[bucket] = new boolean[bucketItems];
        }
        // if the bucket is not null then make the bucket item index value to true.
        // which means that there is an item present.
        storage[bucket][bucketItem] = true;
    }

    // Time Complexity : O(1)
    public void remove(int key) {
        int bucket = bucketIndex(key);
        int bucketItem = bucketItemIndex(key);

        // if Storage[bucket] is null, that means there aren't any items added in the
        // particular bucket. so return.
        if (storage[bucket] == null)
            return;
        else
            // remove the particular item by making false.
            storage[bucket][bucketItem] = false;

    }

    // Time Complexity : O(1)
    public boolean contains(int key) {
        int bucket = bucketIndex(key);
        int bucketItem = bucketItemIndex(key);
        // if Storage[bucket] is null, that means there aren't any items added in the
        // particular bucket. So return false.
        if (storage[bucket] == null)
            return false;
        else
            // return the value of the storage[bucket][bucketItem]
            return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */