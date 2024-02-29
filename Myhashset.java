// Time Complexity : All three (add, remove, contains) have average complexity of O(1)
// Space Complexity : O(sqrt n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach
// Use two-D arrays, rows stores the refernces to the corresponding column array. The first hash functions helps to calcualte the first part, 
//the second hash function gives the keys to final value. 
class MyHashSet {

    private boolean[][] storage;
    private int primary_elts;
    private int secondary_elts;
    public MyHashSet() {
        this.primary_elts = 1000;
        this.secondary_elts = 1000;
        storage = new boolean[primary_elts][];
        
    }

    private int hash1(int key){
        return key % primary_elts;
    }

    private int hash2(int key){
        return key/primary_elts;
    }
    
    public void add(int key) {
        int primary = hash1(key);
        int secondary = hash2(key);
        if (storage[primary] == null) { // if 
            if (primary == 0){
                storage[primary] = new boolean[this.primary_elts + 1]; // thid handles the case of having a bucket for the nth element as the indices start from 0
            }
            else{
                storage[primary] = new boolean[this.primary_elts];
            }
        }
        storage[primary][secondary] = true;
    }
    
    public void remove(int key) {
        int primary = hash1(key);
        int secondary = hash2(key);
        if (storage[primary] == null) return;
        storage[primary][secondary]= false;
        
        
    }
    
    public boolean contains(int key) {
        int primary = hash1(key);
        int secondary = hash2(key);
        if (storage[primary] == null) return false;
        return storage[primary][secondary];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */