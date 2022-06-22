// Time Complexity :
// add() - O(1)
// remove() - O(1)
// contains() - O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;
    int bucketIndices;
    int bucketItemIndices;

    // initializing required variables
    public MyHashSet() {
        bucketIndices = 1000;
        bucketItemIndices = 1000;
        storage = new boolean[bucketIndices][];
    }
    
    // hash function 1
    int getBucketIndex(int key) {
        return key % bucketIndices;
    }
    
    // hash function 2
    int getBucketItemIndex(int key) {
        return key / bucketItemIndices;
    }
    

    public void add(int key) {
        int currentBucket = getBucketIndex(key);
        int currentBucketItem = getBucketItemIndex(key);
        
        // if no bucket items are there then create bucketitems array
        if(storage[currentBucket] == null) {
            if(currentBucket == 0)
                // if bucketitem is in index 0 then  initialize array with one index extra as it might get index 1000
                storage[currentBucket] = new boolean[bucketItemIndices + 1];
            else
                storage[currentBucket] = new boolean[bucketItemIndices];
        }
        // updating the value in given bucket and bucket item index with true
        storage[currentBucket][currentBucketItem] = true;
    }
    
    public void remove(int key) {
        int currentBucket = getBucketIndex(key);
        int currentBucketItem = getBucketItemIndex(key);
        
        // checking if a bucketitem array exists in given bucket index
        if(storage[currentBucket] != null)
            // if bucketitem index exists then update it to false for removing
            storage[currentBucket][currentBucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        int currentBucket = getBucketIndex(key);
        int currentBucketItem = getBucketItemIndex(key);
        
        // if no bucketitem array is present then return false
        if(storage[currentBucket] == null)
            return false;
        // if bucketitem array is present then return the value present as calculate hash index
        return storage[currentBucket][currentBucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */