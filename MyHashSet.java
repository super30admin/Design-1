// MyHashSet using Double Hashing

// Time Complexity : O(1)
// Space Complexity : O(1) - constant space
// Did this code successfully run on Leetcode : Yes - https://leetcode.com/problems/design-hashset/submissions/1036435444/
// Any problem you faced while coding this : No
/*
 * HashSet implementation is to avoid duplicates, collision and maintaining unique hash keys using hashfunction
 * Capacity of hashset is 10^6; First hashing: 10^3 (square root of capacity) and Second Hashing: 10^3
 */

/* Algorithm:
1. Maintain 2 arrays of sizes 1000: primary array - bucket, secondary array- bucketItems
2. Use hashing to getBucket and getBucketItem
3. i. Add the item after checking the bucket value; if null then create a secondary array of bucketItems to that bucket and mark it as true
   ii. remove the item after checking the bucket value; if null then return; else mark the bucketIteam as fasle
*/

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    public MyHashSet() {
        this.buckets= 1000;
        this.bucketItems =1000;
        storage = new boolean[buckets][];
    }
    int getBucket(int key){
        return key % buckets;
    }
    int getBucketItem(int key){
        return key / bucketItems;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
                 storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}