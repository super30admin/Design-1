// Time Complexity : 0(1) for add, remove and contains operations
// Space Complexity : O(mn), m is the bucketKey size, n is the bucketItems size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MyHashSet {

    int buckets, bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        //as there are 1000000 elements, divide it by half and assign 1000 buckets,
        // remaining 1000 for bucketitems if that bucket is chosen
        buckets = 1000;
        bucketItems = 1000;

        //By default, boolean array assigns null to 1000 buckets since secondary array is undefined. It is defined only when the necessity occurs
        storage = new boolean[1000][];
    }

    //1st hashing function to find the bucket
    private int getBucketKey(int key){
        return (key % buckets);
    }

    //2nd hashing function to find bucket items
    private int getBucketItem(int key){
        return (key / bucketItems);
    }

    public void add(int key) {
        //Finding the index of primary storage array
        int bucket = getBucketKey(key);

        //Finding the index of secondary storage array
        int bucketItem = getBucketItem(key);

        //if the bucket is null, is not initialized yet, so initialize it with bucketItems size
        if(storage[bucket] == null){


            if(bucket == 0){
                //This is to prevent the edge case of 1000000 entry.
                storage[bucket]  = new boolean[bucketItems+1];
            }else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucketKey(key);
        int bucketItem = getBucketItem(key);

        //return empty as the bucket does not contain any value and uninitialized
        if(storage[bucket] == null){
            return;
        }

        //mark the value as false indicating that it has been removed
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBucketKey(key);
        int bucketItem = getBucketItem(key);

        //return false as the bucket does not contain any value and uninitialized
        if(storage[bucket] == null){
            return false;
        }
        //return true if the value exists or false if the value does not exist
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