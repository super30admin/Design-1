// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// To implement a HashSet, the most important point was to avoid duplicates. 
// Which means, no hash collision should happen and hash function should produce unique keys.
// Total capacity of HashSet is 1000000, so First hashing is 1000 (sqrt of total capacity) 
// and second hashing is 1000 (remaining)

public class HashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public HashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public int getBucket(int key) {
        return key % buckets;
    }

    public int getBucketItem(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            if(bucket == 0) storage[bucket] = new boolean[bucketItems+1];
            else storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) return;
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */