/*
 * Approach:
 *  1. Create a boolean matrix with size - sqrt(maxRange) x sqrt(maxRange).
 *      if maxRange is not perfect square, take the upperbound of sqrt.
 * 
 *  2. Double Hashing:
 *         Hash function 1: key % primary array size sqrt(maxRange)
 *         Hash function 2: key / secondary array size sqrt(maxRange)
 * 
 *  Important: Secondary array is created based on the requirement, 
 *          otherwise we can directly use 1D array with size -> maxRange
 * 
 *  3. For a given key, get the primary array index(bucket number) using HF1,
 *          and secondary array index(bucket item number) using HF2,
 *          and store/read/check the value.
 * 
 * 
 * Did this code successfully run on Leetcode : YES
 * 
 * Any problem you faced while coding this : NO
 * 
 * Time Complexity:
 *  add, remove, contains - O(1)
 * 
 * Space Complexity:
 *  O(n) - auxilary array is used
 */

class MyHashSet {
    private boolean[][] array;

    private int buckets;

    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.array = new boolean[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucketNo = getBucket(key),
                bucketItemNo = getBucketItem(key);

        if (array[bucketNo] == null) {
            if (bucketNo == 0)
                array[bucketNo] = new boolean[bucketItems + 1];
            else
                array[bucketNo] = new boolean[bucketItems];
        }

        array[bucketNo][bucketItemNo] = true;
    }

    public void remove(int key) {
        int bucketNo = getBucket(key),
                bucketItemNo = getBucketItem(key);

        if (array[bucketNo] == null)
            return;

        array[bucketNo][bucketItemNo] = false;
    }

    public boolean contains(int key) {
        int bucketNo = getBucket(key),
                bucketItemNo = getBucketItem(key);

        if (array[bucketNo] == null)
            return false;

        return array[bucketNo][bucketItemNo];
    }
}