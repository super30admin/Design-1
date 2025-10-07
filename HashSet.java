// Design Hashset
// https://leetcode.com/problems/design-hashset/

// Time Complexity : add, remove, contains - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class MyHashSet {

    private boolean storage [][];
    private int buckets;
    private int bucketItems;


    public MyHashSet() {
        this.buckets = 1000; 
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key){
        return key % this.buckets;
    }

    private int hash2(int key){
        return key / this.bucketItems;
    }
    
    public void add(int key) {
        int bucket = hash1(key);

        if(storage[bucket] == null){
            if(bucket == 0){  // edge case for largest value
                storage[bucket] = new boolean[bucketItems + 1];
            }else{
                storage[bucket] = new boolean[bucketItems];
            }
        }

        int bucketItem = hash2(key);

        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null){
            return;
        }

        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null){ 
            return false;
        }

        return storage[bucket][bucketItem];
    }
}