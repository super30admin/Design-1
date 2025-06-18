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

    /* 
    Initializing the length of 'Buckets' and 'BucketItems'. Defining the parameter of
    storage.
     */
    public MyHashSet() {
        this.Buckets = 1000;
        this.BucketItems = 1000;
        storage = new boolean[this.Buckets][];
    }

    /*
    Obtaining the values for 'Buckets' and 'BucketItem'.
    'Bucket' is the remainder when the value is divided by the length.
    'BucketItem' is the quotient when the claue is divided by the length.
    These provide the location where the value is to be stored.
    */
    int getBuckets(int key){
        return key % this.Buckets;
    }

    int getBucketItems(int key){
        return key / this.BucketItems;
    }
    
    /*
    Checking if the storage is empty.
    If it is empty , then creating the second hash set at the 'Bucket' location.
    If it is not empty, then the value is stored at the specified 'BucketItem' location.
     */
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
    
    /*
    If the Second Hash set is empty, then returns empty.
    Else, the value at the location is deleted.
     */
    public void remove(int key) {
        int Bucket = getBuckets(key);
        int BucketItem = getBucketItems(key);
        if (storage[Bucket] == null){
            return;
        }
        storage[Bucket][BucketItem] = false;
    }
    
    /*
    Checking if the location specified is empty.
    If the location is empty, then it returns false.
    Else, the value stored is returned.
     */
    public boolean contains(int key) {
        int Bucket = getBuckets(key);
        int BucketItem = getBucketItems(key);
        if (storage[Bucket] == null){
            return false;
        }
        return storage[Bucket][BucketItem];
    }
}