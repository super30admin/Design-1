// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : null

class MyHashSet {

    boolean[][] storage;
    int buckets; //primary
    int bucketItems; //secondary

    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key){
        return key % buckets; //primary
    }

    private int getBucketItem(int key){
        return key / bucketItems; //secondary
    }
    
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if (storage[bucket]==null){
            if (bucket==0){
                storage[bucket]=new boolean[bucketItems+1];
            } //for index 1000
            else{
                storage[bucket]=new boolean[bucketItems];
            }   
        } // if value is null then start a secondary hash function
        storage[bucket][bucketItem]=true;

    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null){
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