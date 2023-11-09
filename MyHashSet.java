class MyHashSet {
    int outerArraySize;
    int innerArraySize;
    boolean[][] storage;

    public MyHashSet() {
        outerArraySize=1000;
        innerArraySize=1000;
        storage=new boolean [outerArraySize][];
    }
    public int outerHash(int key){
        return key % outerArraySize;
    }
    public int innerHash(int key){
        return key / innerArraySize;
    }
    public void add(int key) {
        int outerIndex=outerHash(key);
        int innerIndex=innerHash(key);
        if(storage[outerIndex]==null)
        {
            if (outerIndex==0){
                storage[outerIndex]=new boolean[innerArraySize+1];
            }
            else{
                 storage[outerIndex]=new boolean[innerArraySize];
            }
           
        }
        storage[outerIndex][innerIndex]=true;
        
    }
    
    public void remove(int key) {
        int outerIndex=outerHash(key);
        
        if (storage[outerIndex]!=null){
            int innerIndex=innerHash(key);
            storage[outerIndex][innerIndex]=false;
        }
        
    }
    
    public boolean contains(int key) {
        int outerIndex=outerHash(key);
        if (storage[outerIndex]==null){
            return false;
        }
        else{
            int innerIndex=innerHash(key);
            return storage[outerIndex][innerIndex];
        }
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */