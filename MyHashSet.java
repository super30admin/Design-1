// Time Complexity : O(1) for add, remove and contains
// Space Complexity : O(1) as we are not adding space according to the input we are creating constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Mistake was instializing secondary array in the constructor


// Your code here along with comments explaining your approach

class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {

        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][]; //Mistake was instializing secondary array here only
    }
    // Implementing HashSet using Double Hashing

    public int getBucket(int key){ // gets the primary index
        return key % buckets;
    }

    public int getBucketItem(int key){ // gets the secondary index
        return key / bucketItems;
    }


    public void add(int key) {

        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null){

            if(bucket == 0){ // For Edge Case 10^6
                storage[bucket] = new boolean[bucketItems + 1];
            }else{
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */