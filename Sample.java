// Time Complexity : O(1) for add, remove, contains
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    int pb;
    int sb;
    boolean [][] storage;

    public MyHashSet() {
        this.pb = 1000;
        this.sb = 1000;
        storage = new boolean[pb][];
    }
    int hash1(int key){
        return key % pb;
    }
    int hash2(int key){
        return key / sb;
    }

    public void add(int key) { // O(1)
        int pI = hash1(key);
        if (storage[pI] == null){
            if (pI == 0){
                storage[pI] = new boolean[sb + 1];
            }else{
                storage[pI] = new boolean[sb];
            }
        }
        int sI = hash2(key);
        storage[pI][sI] = true;
        
    }
    
    public void remove(int key) { // O(1)
        int pI = hash1(key);
        if (storage[pI] == null){
            return;
        }
        int sI = hash2(key);
        storage[pI][sI] = false;
    }
    
    public boolean contains(int key) { // O(1)
        int pI = hash1(key);
        if (storage[pI] == null){   
            return false;
        }
        int sI = hash2(key);
        return storage[pI][sI];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */