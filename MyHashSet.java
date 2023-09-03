// Time Complexity : O(1) for all functions as getBucket() and getBucketItem() takes O(1) and storing and deleting element also takes O91) time
// Space Complexity : O(n) where n is the maximum number of value we can store, in this case 10^6.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially faced problem with deciding size of array and hash funtions.

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] primaryArray;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        primaryArray = new boolean[buckets][];
    }

    public int getBucket(int key){
        return key % buckets;
    }

    public int getBucketItem(int key){
        return key / bucketItems;
    }
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(primaryArray[bucket] == null){
            if(bucket == 0){
                primaryArray[bucket]  = new boolean[bucketItems + 1];
            }else{
                primaryArray[bucket]  = new boolean[bucketItems];
            }

        }
        primaryArray[bucket][bucketItem] = true;

    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(primaryArray[bucket] == null){
            return;
        }
        primaryArray[bucket][bucketItem] = false;

    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(primaryArray[bucket] == null){
            return false;
        }
        return primaryArray[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
