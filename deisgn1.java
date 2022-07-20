// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I tried to code in python but I did not know how to create a array of boolean, so tried submitting my code in java

// Your code here along with comments explaining your approach 
// create an hash1 and hash2 (to avoid collision we are creating a equally distributed boolean array matrix of size 1000*1000 as the input size is 10^6, now we can add, remove and check if the key is present in the hashset using the below methods)



class MyHashSet {
    private boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean [buckets][];
    }
    
    public int hash1(int key){
        return key%buckets;
    }
    
    public int hash2(int key){
        return key/buckets;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if(storage[hash1] == null){
            if(hash1 == 0){
                storage[hash1] = new boolean[bucketItems + 1];
            }else{
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2]=true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if(storage[hash1] == null) return;
        
        storage[hash1][hash2]=false;
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        
        if(storage[hash1]==null) return false;
        return storage[hash1][hash2];
        
    }
}


