// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//We are using double hasing for solving collisions and are using boolean 2D array for simplification


class MyHashSet {
    boolean[][] storage; //2D boolean array
    int buckets;
    int bucketItems;
    public MyHashSet() {
        //since the range is 10^6, we take square root of the range for primary array (10^3)
        buckets=1000; //length of primary array
        bucketItems=1000; //length of secondary array
        storage= new boolean[buckets][];
        }
    
    
    public void add(int key) {
int bucket=getBucket(key); // to find the index in primary array
        int bucketItem= getBucketItem(key);// to find the index in secondary array
            
            if(storage[bucket]==null){
                if(bucket==0){
                   storage[bucket]= new boolean[bucketItems +1]; //To handle edge case for 10^6 
                }
                else{
                    storage[bucket]= new boolean[bucketItems]; //initialize secondary array
                }
            }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
int bucket=getBucket(key); // to find the index in primary array
        int bucketItem= getBucketItem(key);// to find the index in secondary array
             if(storage[bucket]==null){
                 return;
             }
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
int bucket=getBucket(key); // to find the index in primary array
        int bucketItem= getBucketItem(key);// to find the index in secondary array
        if(storage[bucket]== null){
            return false;
        }
        else return storage[bucket][bucketItem]; 
        //will give true or false since it is a boolean array
    }
    //Double Hashing
    public int getBucket(int key){
       return key% buckets; //for primary array
    }
    public int getBucketItem(int key){
       return key/ bucketItems; //for secondary array
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */