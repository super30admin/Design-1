// Time Complexity : for add , remove and insert is O(1)
// Space Complexity : no extra auxillary space used other than the one initialised via constructor 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class MyHashSet {

    private int buckets; // primary array size
    private int bucketItems; // nested array size
    boolean[][] storage;
    public MyHashSet() {
       this.buckets=1000;
       this.bucketItems=1000;  
       storage = new boolean[buckets][]; // creating only primary array with nulls , and not sec array
    
    }
    
    // to get the index in primary array 
    public int bucket(int key){
        return key%buckets;
    }

     // to get the index in secondary array
    public int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket= bucket(key);
        int bucketItem= bucketItem(key);
        if(storage[bucket]==null){
            if(bucket==0){
                 storage[bucket]=new boolean[bucketItems+1]; // to insert 10^6 at 1000 idx
            }
            else{
                  storage[bucket]=new boolean[bucketItems];
            }
          
        }
        storage[bucket][bucketItem]=true;

    }
    
    public void remove(int key) {
        int bucket= bucket(key);
        int bucketItem= bucketItem(key);
        if(storage[bucket]==null) return;
         storage[bucket][bucketItem]=false;
        
    }
    
    public boolean contains(int key) {
        int bucket= bucket(key);
        int bucketItem= bucketItem(key);
        if(storage[bucket]==null) // no secondary array
         return false;
         return storage[bucket][bucketItem];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */