// Time Complexity : o(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashSet {

    boolean[][] b;
    int buckets;
    int bucketItems;
    
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        b= new boolean[buckets][];
    }
    
    private int getBucket(int key){
        return key % buckets;
    }
    
    private int getBucketItem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(b[bucket]==null){
            if(bucket==0){
            b[bucket]= new boolean[bucketItems+1];
          
            }else{
            b[bucket]= new boolean[bucketItems];
           
            }
        }
            b[bucket][bucketItem]= true;
        
    }
    
    public void remove(int key) {
       int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(b[bucket]==null){
            return;
        }
        b[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(b[bucket]==null){
            return false;
        }
        return b[bucket][bucketItem];
    }
}

MY APPROACH:
Here we take nested array and as we can deal with indices we can just maintain keys in boolean array like -> true means that index is key which is available in hashset 

