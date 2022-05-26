// Time Complexity : o(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyHashSet {
    
    int buckets;
    int bucketItems;
    private boolean[][] storage;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketList = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean [bucketItems + 1];
            }else{
                storage[bucket] = new boolean [bucketItems];
            }
        }
        storage[bucket][bucketList] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketList = hash2(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketList] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketList = hash2(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketList];
    }
    
    private int hash1(int key){
        return key%buckets;
    }
    
    private int hash2(int key){
        return key/bucketItems;
    }
}