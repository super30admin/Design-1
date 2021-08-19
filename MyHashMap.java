// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    int[][] storage;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }


    private int getBucket(int key){ // Hashing function 1
        return key % buckets;
    }

    private int getBucketItem(int key){ // Hashing function 2
        return key / bucketItems;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // Get unique hashing values for each key - value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // Initialise nested array only when required and fill the empty elements with -1
        if(storage[bucket] == null){
            if(bucket == 0){ // There is a need for one extra array element if the key is one million
                storage[bucket] = new int [bucketItems + 1];
                Arrays.fill(storage[bucket], -1);
            } else {
                storage[bucket] = new int [bucketItems];
                Arrays.fill(storage[bucket], -1);
            }
        }
        // Store the value
        storage[bucket][bucketItem] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // Get unique hashing values for each key - value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // If there is null sub-array, return -1
        if(storage[bucket] == null) return -1;
        // If the array element is not filled in the sub-array, return -1
        if((storage[bucket][bucketItem]) == -1) return -1;
        // else return the element stored
        return storage[bucket][bucketItem];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // Get unique hashing values for each key - value pair
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (storage[bucket] == null) return; // Check for empty sub-array
        storage[bucket][bucketItem] = -1; // else change the element's value to -1
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */