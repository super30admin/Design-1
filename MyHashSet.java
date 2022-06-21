// Time Complexity : O(1)
// Space Complexity : O(1) (O(1000X1000) which is constant)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// created an 2d array with indexs as values using 2 hash function
class MyHashSet {

    boolean[][] outer;
    int noOfBuckets;
    int bucketItems;
    
    public MyHashSet() {    
        //sqrt of Max value given 
        noOfBuckets = (int)Math.sqrt(1000000);
        bucketItems = noOfBuckets;
        outer = new boolean[noOfBuckets][];
    }
    
    int getBucket(int num){
        return num % noOfBuckets;
    }
    
    int getBucketItem(int num){
        return num/bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int item = getBucketItem(key);
        if(outer[bucket] == null){
            if(bucket == 0){
                outer[0] = new boolean[bucketItems + 1];
            }
            else {
                outer[bucket] = new boolean[bucketItems];
            }
        }
        outer[bucket][item] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int item = getBucketItem(key);
        if(outer[bucket]==null){
            return;
        }
        outer[bucket][item] = false;
    }   

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int item = getBucketItem(key);
        if(outer[bucket]==null){
            return false;
        }
        return outer[bucket][item];
    }
}
