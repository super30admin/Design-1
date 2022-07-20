// Time Complexity : O(1) 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean [][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems =1000;
        this.storage = new boolean [buckets][];
    }
    
    private int hash1(int key){
        return key%buckets;
    }
    
    private int hash2(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int var = hash1(key);
        int var2 = hash2(key);
        if(storage[var] == null){
            if(var==0){
                storage[var]=new boolean[bucketItems + 1];
            }
            else{
                storage[var] = new boolean[bucketItems];
            }
        }
        storage[var][var2]=true;
    }
    
    public void remove(int key) {
        int var = hash1(key);
        int var2 = hash2(key);
        if(storage[var]==null) return;
        storage[var][var2]=false;
    }
    
    public boolean contains(int key) {
        int var = hash1(key);
        int var2 = hash2(key);
        if(storage[var]==null) return false;
        return storage[var][var2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */