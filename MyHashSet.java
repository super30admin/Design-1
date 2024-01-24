class MyHashSet {
    private boolean[][] storage;
    private int primaryArraySize;
    private int secondaryArraySize;
    public MyHashSet() {
        primaryArraySize = 1000;
        secondaryArraySize = 1000;
        storage = new boolean[primaryArraySize][];
    }
    
    public void add(int key) {
        int primaryIndex = hash1(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex==0)
                storage[primaryIndex] = new boolean[secondaryArraySize+1];
            else
                storage[primaryIndex] = new boolean[secondaryArraySize];
        }
        int secondaryIndex = hash2(key);
        storage[primaryIndex][secondaryIndex] = true;
    }

    private int hash1(int key){
        return key%primaryArraySize;
    }

     private int hash2(int key){
        return key/secondaryArraySize;
    }
    
    public void remove(int key) {
        int primaryIndex = hash1(key);
        if(storage[primaryIndex] == null) return;
        int secondaryIndex = hash2(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = hash1(key);
        if(storage[primaryIndex] == null) return false;
        int secondaryIndex = hash2(key);
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