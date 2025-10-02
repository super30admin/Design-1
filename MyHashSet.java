// Time Complexity :
// add()  -> O(1)
// remove()   -> O(1)
// contains() -> O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    private boolean [][] myHashSet; 
    private int priArraySize;
    private int secArraySize;

    public MyHashSet() {
        this.priArraySize = 1000;
        this.secArraySize = 1000;
        this.myHashSet = new boolean[priArraySize][];
    }
    
    public void add(int key) {
        int priArrayElement = hash1(key);
        if (myHashSet[priArrayElement] == null) {
            if (priArrayElement == 0) {
                myHashSet[priArrayElement] = new boolean[secArraySize + 1];
            } else {
                myHashSet[priArrayElement] = new boolean[secArraySize];
            }
        }
        int secArrayElement = hash2(key);
        myHashSet[priArrayElement][secArrayElement] = true;
    }
    
    public void remove(int key) {
        int priArrayElement = hash1(key);
        int secArrayElement = hash2(key);
        if (myHashSet[priArrayElement] == null) {
            return;
        }
        myHashSet[priArrayElement][secArrayElement] = false;
    }
    
    public boolean contains(int key) {
        int priArrayElement = hash1(key);
        int secArrayElement = hash2(key);
        if (myHashSet[priArrayElement] == null) {
            return false;
        }
        return myHashSet[priArrayElement][secArrayElement];
    }

    private int hash1(int key) {
        return key % priArraySize;
    }
    private int hash2(int key) {
        return key / priArraySize;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */