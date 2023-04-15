// Time Complexity : O(1) for add remove and contains method
// Space Complexity : O(n*m) where n is the number of the bucket and m in the max number of elements in that bucket
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Confusion regarding space complexity as we predifned the sizes of buckets to be 1000  
//and trouble understanding why the secondary array is filled with false but primary array with null.


// Your code here along with comments explaining your approach
/*
 * We can use the whole array of 10^6 but to demonstrate the collision and resolution we use double hashing. 
 * We define arrays covering the all 10^6 items, i.e., if primary is 10^3 we initialize secondary array as 10^3 as well and also 2 hashing function smartly one with mod and then divide.
 * Based on above thing we define add, remove and contains. Add: check primary if null, initialize  secondar arraya and add. Remove: check if exists and remove. 
 */

public class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }
    
    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } 
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
        return;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}
