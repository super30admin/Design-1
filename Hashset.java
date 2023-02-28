class MyHashSet {

    /** Initialize your data structure here. */
    boolean storage[][];
    int indexes;
    int indexesOfI;
    public MyHashSet() {
        indexes = 1001;
        indexesOfI = 1000;
        storage= new boolean[indexes][];
    }
    
    public void add(int key) {
        int index = key/indexesOfI;
        int indexOfI = key%indexesOfI;
        if(storage[index]==null)
        {
            storage[index] = new boolean[indexesOfI];
        }
        
        storage[index][indexOfI] = true;
    }
    
    public void remove(int key) {
        int index = key/indexesOfI;
        int indexOfI = key%indexesOfI;
        if(storage[index]==null)return;
        storage[index][indexOfI] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key/indexesOfI;
        int indexOfI = key%indexesOfI;
        if(storage[index]==null)return false;
        return storage[index][indexOfI];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */