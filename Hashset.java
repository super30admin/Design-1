// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    
    private int bucket = 1000;
    private int bucketItem = 1000;
    
    private int hashfunc1(int key){
        return key % bucket;
    }
    
    private int hashfunc2(int key){
        return key / bucketItem;
    }

    private boolean[][] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset = new boolean[bucket][];
    }
    
    public void add(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        if(hashset[index1] == null){
            if(index1 == 0){
                hashset[index1] = new boolean[bucketItem + 1];
            }else{
                hashset[index1] = new boolean[bucketItem];
            }  
        }
        hashset[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        if(hashset[index1] == null){
            return;
        }
        hashset[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        return hashset[index1] != null && hashset[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */