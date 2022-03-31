// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Hashmap using double hashing.
class MyHashMap {
    
    int buckets;        // Primary Array.
    int bucketItems;    // Secondary Array.
    Integer[][] data;   // 'Integer' is object, can store nulls unlike int[][].

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        data = new Integer[buckets][];  // Initialize null in primary array.
    }
    
    // Get primary array index.
    // Time complexity: O(1)
    private int getPrimaryHash(int key) {
        // return key % buckets;
        return Integer.hashCode(key) % buckets;
    }
    
    // Get secondary array index.
    // Time complexity: O(1)
    private int getSecondaryHash(int key) {
        return Integer.hashCode(key) / bucketItems;
    }
    
    // Time complexity: O(1)
    // Space complexity: O(1)
    public void put(int key, int value) {
        int bucket = getPrimaryHash(key);
        int bucketItem = getSecondaryHash(key);
        if(data[bucket] == null) {
            if(bucket == 0) {       
                data[bucket] = new Integer[bucketItems + 1];    // 0 - 10^6
            }
            else {
                data[bucket] = new Integer[bucketItems];
            }
        }
        data[bucket][bucketItem] = value;
    }
    
    // Time complexity: O(1)
    // Space complexity: O(1)
    public int get(int key) {
        int bucket = getPrimaryHash(key);
        int bucketItem = getSecondaryHash(key);
        if(data[bucket] == null) {
            return -1;
        }
        if(data[bucket][bucketItem] != null) {
            return data[bucket][bucketItem];
        }
        return -1;
    }
    
    // Time complexity: O(1)
    // Space complexity: O(1)
    public void remove(int key) {
        int bucket = getPrimaryHash(key);
        int bucketItem = getSecondaryHash(key);
        if(data[bucket] == null) {
            return;
        }
        if(data[bucket][bucketItem] != null) {
            data[bucket][bucketItem] = null;
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */