/*
*Approach - take bucket as outer DS and BucketItms as Inner DS. 
* Intialize both with 1000. 
* e have storage defined as boolean , so if we have key, we put true, else it will be intialized as false only. 
*Time Complexity - Add, remove, contains- O(1)
*Space complexity - avg - O(1000*1000) || worstO(n*n)*/

class MyHashSet {
    
    //intialize array, sub-array.
    boolean[][] storage;
    int bucket;
    int bucketItems;
    

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1001;
        this.storage = new boolean[bucket][];
        }
    
    private int hash1(int value) //calculate outer index
    {
        return value%bucket;        
    }
    private int hash2(int value) //calculate nested/inner index
    {
        return value/bucketItems;
    }
    
    public void add(int key) {
        int out_index = hash1(key);
        int in_index = hash2(key);
        
        if(storage[out_index] == null )
        {
                storage[out_index] = new boolean[bucketItems];
        }
        
        storage[out_index][in_index] = true;
    }
    
    public void remove(int key) {
        int out_index = hash1(key);
        int in_index = hash2(key);
        
        if(storage[out_index] == null )
            return;
        
        storage[out_index][in_index] = false;
    }
    
    public boolean contains(int key) {
      int out_index = hash1(key);
      int in_index = hash2(key);
        
        if(storage[out_index] == null )
            return false;
        
        return storage[out_index][in_index];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */