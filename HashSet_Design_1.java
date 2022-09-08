// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class hashSet() {
    //boolean storage for hashset with # of buckets and # of bucketItems in each bucket.
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public hashSet() {
        //Initializing buckets and bucketItems based on given range.
        //Hack - use of sq. root of max range to get size of primary array.
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key) {
        //first hash function
        return key % buckets;
    }

    private int getBucketItemz(int key) {
        //second hash function
        return key/bucketItems;
    }

    public void add(int key) {
        //to get index in primary array
        int bucket = getBucket(key);
        //check if the key is already present in hashset
        if(!contains(key)) {
            //to get index of secondary array.
            int bucketItem = getBucketItem(key);
            //if primary array have null at bucket index, initialize secondary array based on bucket value.
            //If buck == 0 then secondary array size is bucketItems+1 (to cover edge case) else size is of secondary array.
            if(storage[bucket] == null) {
                if (bucket == 0) {
                    storage[bucket] = new boolean[bucketItems+1];
                } else {
                    storage[bucket] = new boolean[bucketItems];
                }
            }
            //assign value true to add element in hashset
            storage[bucket][bucketItem] = true;
        }
    }

    public void remove(int key) {
        //check if key is present to remove, if present, get bucket and buckItem values from hash functions and set storage to false.
        if(contains(key)) {
            int bucket = getBucket(key);
            int bucketItem = getBucketItem(key);
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        //to get primary array index
        int bucket = getBucket(key);
        //to get secondary array index
        int bucketItem = getBucketItem(key);
        //check if secondary array is initialized or not and return the value at secondary array's index
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}