class MyHashSet {
    int buckets; //for first array
    int bucketItems;//for second array
    boolean[][] storage;

    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key){
        return key % buckets; // for position in first array
    }

    private int getBucketItem(int key){
        return key / bucketItems; //for position in second array
    }

public void add(int key) {
    int bucket = getBucket(key);
    int bucketItem = getBucketItem(key);
    if (storage[bucket] == null){
        if(bucket==0){
            storage[bucket] = new boolean[bucketItems+1];//for inex 0 in first array because of 1000000 values (arrays starts with 0)
        }
        else
            storage[bucket] = new boolean[bucketItems]; // creating boolean array in first array position
    }
        storage[bucket][bucketItem] = true;
}

    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null)
            return;
        storage[bucket][bucketItem]=false;      
    }
    
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null)
            return false;
        return storage[bucket][bucketItem];  //returning the boolean value that is stored on second array
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// Time Complexity : O(1)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
