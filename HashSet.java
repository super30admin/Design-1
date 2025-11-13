// Time Complexity :O(1)
// Space Complexity :O(primaryBuckets × secondaryBuckets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had some issues with the syntax other than that i am good


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


// Your code here along with comments explaining your approach
// for add function, i checked if there are any elements in that index in 1st array if not initialized an array and kept that particular element in its hashed index
// for remove, and contain- i checked whether that index is there is or not id there i removed it, and for contain i return true/false
class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][];
    }
    public int hash1(int key){
        return key%primaryBuckets;
    }
    public int hash2(int key){
        return key/secondaryBuckets;
    }
    
    public void add(int key) {
        int hash_1 = hash1(key);
        int hash_2 = hash2(key);
        if (storage[hash_1] == null){
            if (hash_1 == 0){
               storage[hash_1] = new boolean[secondaryBuckets+1];
            }
            else{
                storage[hash_1] = new boolean[secondaryBuckets];
            }
        }
        storage[hash_1][hash_2] = true; 
    }
    
    public void remove(int key) {
        int hash_1 = hash1(key);
        int hash_2 = hash2(key);
        if(storage[hash_1] == null){
            return;
            }
        storage[hash_1][hash_2] = false;        
    }
    
    public boolean contains(int key) {
        int hash_1 = hash1(key);
        int hash_2 = hash2(key);
        if (storage[hash_1] == null){
            return false;
        }
        return storage[hash_1][hash_2];
        
    }
}