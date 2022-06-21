// Time Complexity : O(1)
// Space Complexity : O(N+M) where n is size of bucket and M is total elements in boolean array initialized
// Did this code successfully run on Leetcode : Yes,
// Any problem you faced while coding this : Trying to remember the basic java syntaxs and in naming conventions.


// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] bucket; // declaring the boolean bucket
    int bucketSize; //declaring the size of the bucket
    public MyHashSet() {
        bucketSize=1000; // setting value
        bucket = new boolean[bucketSize][]; //initializing the bucket
    }

    public int getBucket(int key){
        return key%bucketSize; // hash method 1
    }

    public int getBucketItem(int key){
        return key/bucketSize; // hash method 2
    }

    public void add(int key) {
        int bucketNo = getBucket(key);//getting values from hash methods
        int bucketItemNo = getBucketItem(key);
        if(bucket[bucketNo] == null){ // if the corresponding boolean array is not initialized then initializing the arrays based on following 2 scenarios
            if(bucketNo == 0){ // this method is required to cover the scenario when the input is 10^6
                bucket[bucketNo] = new boolean[bucketSize + 1];
            }else{
                bucket[bucketNo] = new boolean[bucketSize]; // normal scenario where we need only 999 elements
            }
        }
        bucket[bucketNo][bucketItemNo] = true; // then setting that particular index as true signifying that this element is present in the hashSet.
    }

    public void remove(int key) {
        int bucketNo = getBucket(key);
        int bucketItemNo = getBucketItem(key); //getting index of the particular position thru hash functions

        if(bucket[bucketNo] == null){
            return; // if the particular boolean array is null, it means that element is not present in the hashSet, no need to remove.
        }

        bucket[bucketNo][bucketItemNo] = false; // if present or boolean array exists, then set the value to false i.e. doesn't exists
    }

    public boolean contains(int key) {
        int bucketNo = getBucket(key); //
        int bucketItemNo = getBucketItem(key);
        if(bucket[bucketNo] == null){ // if the array is not iitialized, then not present
            return false;
        }

        return bucket[bucketNo][bucketItemNo]; // if the array is initialized, then return the value at the index.
    }
}