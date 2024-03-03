// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Explain your approach in **three sentences only** at top of your code

//Design-1

//## Problem 1:(https://leetcode.com/problems/design-hashset/)

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    
    public int hash1(int key) {
        return key % this.buckets;
    }

    public int hash2(int key) {
        return key/this.buckets;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems+1];
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return false;
        else return storage[bucket][bucketItem];
    }
}



