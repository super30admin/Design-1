// double hashing
// time complexity o(1) for each opertaion
// space complexity is constant

class MyHashSet {

    int buckets;
    int bucketSize;
    boolean[][] storage;


    public MyHashSet() {
       this.buckets = 1000;
       this.bucketSize = 1000;
       storage = new boolean[buckets][];
        
    }
    
    private int getOuterHashCode(int key)
    {
        return key % buckets;
    }

    private int getInnerHashCode(int key)
    {
        return key / bucketSize;
    }
    public void add(int key) {
        // GET outer hash
        int outerHash = getOuterHashCode(key);
        if(storage[outerHash] == null)
        {
            // initalized outer bucket
            storage[outerHash] = new boolean[bucketSize+1];


        }

        int innerHash = getInnerHashCode(key);

       
            storage[outerHash][innerHash] = true;
        
    }
    
    public void remove(int key) {
         int outerHash = getOuterHashCode(key);
        if(storage[outerHash] != null){
              int innerHash = getInnerHashCode(key);
            storage[outerHash][innerHash] = false;
        }

    }
    
    public boolean contains(int key) {
          int outerHash = getOuterHashCode(key);
        if(storage[outerHash] == null)
            return false;
        else{
              int innerHash = getInnerHashCode(key);
            return storage[outerHash][innerHash];
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