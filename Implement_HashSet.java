// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
    //As the key can be anywhere between 0 and 10^6(given in the question). We take the square root of the maximum value that is 10^6 as the bucket size.
    //We took this decison considering that we design a hash function that can allow equal distribuition of keys in the array.
    buckets=1000;
    bucketItems=1000;
    // we initially allocate memory for only the primary array to minimize the usage of space.
    storage= new boolean[buckets][];
    }
    // first hash function
    private int hash1(int key){
        return key%buckets;
    }
    // second hash function
    private int hash2(int key){
        return key/bucketItems;
    }
    public void add(int key) {
    // hash1 and hash2 are the values of indices where the keys will be stored. we get these by applying hash functions to keys.
       int hash1=hash1(key);
       int hash2=hash2(key);
       //if there is no key in that particular index(hash1), it will check for a condition that if the value is 0 or not after computing the hash function.
       // if the value is 0, then when the second hash is calculated, we get in the atmost case (1000)/(10^6)=1000 ( but we have only indices starting from 0 to 999)
       // so we increase secondary array size by 1 in the above condition. Else, we just create an array with the same size as primary array.
        if(storage[hash1]==null){
            if(hash1==0){
               storage[hash1] = new boolean[bucketItems+1]; 
            } else {
               storage[hash1] = new boolean[bucketItems];
            }
        }
        //when the value is not empty, its just store the key in the storage[hash1][hash2]. 
        storage[hash1][hash2]=true;
    }
    public void remove(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);
        //if there is no mentioned key in the array, this method will return nothing
        if(storage[hash1]==null) return;
        //else it marks the value in the array as false-> that indicates no elemenst exits in that location.
        storage[hash1][hash2]=false;
    }
    
    public boolean contains(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);
        // when there no such key in the primary array-> this method will return false
        if(storage[hash1]==null) return false;
        //else it checks the location has true or false-> true indicates there is that key else no.
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */