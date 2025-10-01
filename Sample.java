// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * 1. Creating HashSet and use double hashing for resolving collisions.
 * 2. Use 2D square matrix/array for storing values.
 * 3. Primary array will store reference of secondary array.
 * 4. Secondary array will store actual values.
 * 5. For first hash function we will use Modulo(%) with primary array Size.
 * 6. For second hash function we will use division(/) with primary array Size.
 * 7. For 0 index in primary function we have to create a secondary array with (bucket size + 1).
 */
class MyHashSet {

    private int bucketSize = 1000;
    private boolean[][] buckets = new boolean[bucketSize][];

    private int hash1(int key){
        return key % bucketSize;
    }

    private int hash2(int key){
        return key/bucketSize;
    }

    public MyHashSet() {
    }

    // Time Complexity : O(1)
    public void add(int key) {
        if(buckets[hash1(key)]== null){
            if(hash1(key) == 0)
                buckets[hash1(key)] = new boolean[bucketSize + 1];
            else
                buckets[hash1(key)] = new boolean[bucketSize];
        }
        buckets[hash1(key)][hash2(key)] = true;
    }

    // Time Complexity : O(1)
    public void remove(int key) {
        if(buckets[hash1(key)]== null) return;
        buckets[hash1(key)][hash2(key)] = false;
    }

    // Time Complexity : O(1)
    public boolean contains(int key) {
        if(buckets[hash1(key)]== null) return false;
        return buckets[hash1(key)][hash2(key)];
    }
}