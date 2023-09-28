// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    private boolean[][] storage;
    private int psize,ssize;
    public MyHashSet() {
        this.psize = 1000;this.ssize=1000;
        this.storage = new boolean[psize][];
    }
    
    public void add(int key) {
        if(storage[key%psize]==null){
            
                if(key%psize==0)
                    storage[key%psize] = new boolean[ssize+1];
                else
                    storage[key%psize] = new boolean[ssize];
            
            
        }
        storage[key%psize][key/ssize] = true;
    }
    
    public void remove(int key) {
        if(storage[key%psize]!=null)
            storage[key%psize][key/ssize]=false;
    }
    
    public boolean contains(int key) {
        if(storage[key%psize]==null)
        return false;
        return storage[key%psize][key/ssize];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */