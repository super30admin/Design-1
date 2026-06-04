// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



//Leetcode 706. Design HashMap

class MyHashSet {
    int primaryb;
    int secondaryb;
    boolean storage[][];
    public MyHashSet() {
        this.primaryb = 1000;
        this.secondaryb = 1000;
        this.storage = new boolean[primaryb][];
    }
    private int getprimaryhash(int key){
        return key%primaryb;
    }
    private int getsecondaryhash(int key){
        return key/secondaryb;
    }
    
    public void add(int key) {
    int primaryIndex = getprimaryhash(key);

    if(storage[primaryIndex] == null){
        if(primaryIndex == 0){
            storage[primaryIndex] = new boolean[secondaryb + 1];
        } else {
            storage[primaryIndex] = new boolean[secondaryb];
        }
    }

    int secondaryIndex = getsecondaryhash(key);
    storage[primaryIndex][secondaryIndex] = true;
}
    
    public void remove(int key) {
    int primaryIndex = getprimaryhash(key);

    if(storage[primaryIndex] == null){
        return;
    }

    int secondaryIndex = getsecondaryhash(key);
    storage[primaryIndex][secondaryIndex] = false;
}
    
    public boolean contains(int key) {
        int primaryIndex= getprimaryhash(key);
        if(storage[primaryIndex]==null){return false;}
        int secondaryIndex = getsecondaryhash(key);
       return storage[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */