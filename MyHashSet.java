//time complexit = O(1)
//space complexity = O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet (){
        this.primaryBuckets=1000;
        this.secondaryBuckets=1001;
        this.storage=new boolean[primaryBuckets][];
    }

    private int getprimaryHash(int key){
        return key% primaryBuckets;
    }
    private int getsecondaryHash(int key){
        return key/ secondaryBuckets;
    }
    
    public void add(int key) {
     int primaryIndex = getprimaryHash(key);
     if (storage[primaryIndex]==null){
        storage[primaryIndex]= new boolean [secondaryBuckets];
     }   
    
    int secondaryIndex= getsecondaryHash(key);
    storage[primaryIndex][secondaryIndex] = true;
    }
    public void remove(int key) {
        int primaryIndex = getprimaryHash(key);
     if (storage[primaryIndex]==null){
     return;
     }   
    
    int secondaryIndex= getsecondaryHash(key);
    storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
            int primaryIndex = getprimaryHash(key);
     if (storage[primaryIndex]==null){
     return false;
     }   
    int secondaryIndex= getsecondaryHash(key);
    return storage[primaryIndex][secondaryIndex];
    }
}

