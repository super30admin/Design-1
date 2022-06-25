//Time complexity=O(1) for inserting,containing and remove functions
//Space complexity=O(N) N stands for number of entries
class MyHashSet {
private boolean[][] storage;
    int buckets;
    int items;
    
    public MyHashSet() {
        //Creating two arrays for mapping two hashing functions 
        buckets=1000;
        items=1000;
        storage=new boolean[buckets][];
        
    }
    private int bucket(int key){
        return key%buckets;
    }
     private int bucketitems(int key){
        return key / items;
    }
    public void add(int key) {
        //Finding the value to be inserted in the primary bucket array
       int bucket=bucket(key);
        int bucketitems=bucketitems(key);
        if (storage[bucket]==null){
            //We will create a new array here
            if(bucket==0){
                //This is to prevent the edge case of 1000000 entry.
                storage[bucket]=new boolean[items+1];}
                else{
                    storage[bucket]=new boolean[items];
                }
                    
        }
            //Changing the Value of the array to be true to indicate that the item is inserted.
            storage[bucket][bucketitems]=true;

    }
    
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketitems=bucketitems(key);
        if (storage[bucket]==null) return;
        //Changing the valu to false to indicate that the item is removed.
            storage[bucket][bucketitems]=false;
        
    }
    
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketitems=bucketitems(key);
        if (storage[bucket]==null) return false;
        //Returns true if we found the value.
        return storage[bucket][bucketitems];
        }
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */