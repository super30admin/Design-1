//Time Complexity: O(1) - add, remove, contains functions
//Space Complexity: O(1) - add, remove, contains functions
class MyHashSet {

    int buckets;
    int bucketSize;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketSize = 1000;
        storage = new boolean[buckets][];
        
    }

    private int getOuterHashValue(int key){
        return key % buckets;
    }

    private int getInnerHashValue(int key){
        return key / bucketSize;
    }
    
    public void add(int key) {
        int outerHashValue = getOuterHashValue(key);
        if(storage[outerHashValue] == null){
            if (outerHashValue == 0)
                storage[outerHashValue] = new boolean[bucketSize+1];
            else
                storage[outerHashValue] = new boolean[bucketSize];
        }
        int innerHashValue = getInnerHashValue(key);
        if(!storage[outerHashValue][innerHashValue])
        storage[outerHashValue][innerHashValue] = true;
    }
    
    public void remove(int key) {
        int outerHashValue = getOuterHashValue(key);
        if(storage[outerHashValue] != null){
            int innerHashValue = getInnerHashValue(key);
            storage[outerHashValue][innerHashValue] = false;
        }
        
    }
    
    public boolean contains(int key) {
        boolean isPresent = false;
        int outerHashValue = getOuterHashValue(key);
        if(storage[outerHashValue] != null){
            int innerHashValue = getInnerHashValue(key);
            isPresent = storage[outerHashValue][innerHashValue];
        }
        return isPresent;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */