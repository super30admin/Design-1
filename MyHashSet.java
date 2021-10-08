// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class MyHashSet {
    boolean[][] hashSet;
    final int hashSetSize = 1000;
    final int listSize = 1001;
    
    public MyHashSet() {
        this.hashSet = new boolean[hashSetSize][];
    }
    
    public int hashSetIndex(int key) {
        return key%hashSetSize;
    }
    
    public int listIndex(int key) {
        return key/hashSetSize;
    }
    
    public void add(int key) {
        int hashIndex = hashSetIndex(key);
        int listIndex = listIndex(key);
        if(hashSet[hashIndex] == null ) {
            hashSet[hashIndex] = new boolean[listSize];
        } 
        hashSet[hashIndex][listIndex] = true;
        
        
    }
    
    public void remove(int key) {
        int hashIndex = hashSetIndex(key);
        int listIndex = listIndex(key);
        if(hashSet[hashIndex] != null && hashSet[hashIndex][listIndex] == true) {
            hashSet[hashIndex][listIndex] = false;
        }
    }
    
    public boolean contains(int key) {
        int hashIndex = hashSetIndex(key);
        int listIndex = listIndex(key);
        if(hashSet[hashIndex] != null && hashSet[hashIndex][listIndex] == true) {
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
