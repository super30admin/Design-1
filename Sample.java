/* Time Complexity : 
add: O(1)
remove: O(1)
contains: O(1)

Space Complexity :
add: O(n)
remove: O(n)
contains: O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : 
Missing semi-colons and small syntax errors. Logic was clear.

*/

// Your code here along with comments explaining your approach

class MyHashSet {
    int Buckets;
    int BucketItems;
    boolean[][] storage;
    public MyHashSet() {
        this.Buckets = 1000;
        this.BucketItems = 1000;
        storage = new boolean[this.Buckets][];
    }

    int getBuckets(int key){
        return key % this.Buckets;
    }

    int getBucketItems(int key){
        return key / this.BucketItems;
    }
    
    public void add(int key) {
        int Bucket = getBuckets(key);
        int BucketItem = getBucketItems(key);
        if (storage[Bucket] == null){
            if (Bucket == 0) {
                storage[Bucket] = new boolean[this.BucketItems + 1];
            }
            else {
                storage[Bucket] = new boolean[this.BucketItems];
            }            
        }
        storage[Bucket][BucketItem] = true;
    }
    
    public void remove(int key) {
        int Bucket = getBuckets(key);
        int BucketItem = getBucketItems(key);
        if (storage[Bucket] == null){
            return;
        }
        storage[Bucket][BucketItem] = false;
    }
    
    public boolean contains(int key) {
        int Bucket = getBuckets(key);
        int BucketItem = getBucketItems(key);
        if (storage[Bucket] == null){
            return false;
        }
        return storage[Bucket][BucketItem];
    }
}
