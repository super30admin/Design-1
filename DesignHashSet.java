class MyHashSet {
    boolean[][] storage; //creating an array
    int primaryBucket;  //creating a bucket
    int secondaryBucket; //creating a bucket

    public MyHashSet() {
        this.primaryBucket = 1000;
        this.secondaryBucket = 1000;
        this.storage = new boolean[primaryBucket][]; //allocating memory to the array
    }

    int getPrimaryHash(int key){
        return key % primaryBucket;
    }

    int getSecondaryHash(int key){
        return key / secondaryBucket;
    }
    
    public void add(int key) {
        int primaryIndex = getPrimaryHash(key); //assigning key to the first bucket
        if(storage[primaryIndex] == null){//check if to be added key is not already there in 1st bucket then
            if(primaryIndex == 0){ 
                //for 10^6,
                    // val % len
                    //i.e. if 10^6 % 1000 = 0
                    //then 10^6 / 2 = 1000
                    //so, when we have an array from 0 to 999 for a bucket of 1000, we cannot put val at 1000th place which we got above.
                    //Thus, we need an extra array to place the 1000th place and so we increase it by adding 1
                storage[primaryIndex] = new boolean[secondaryBucket+1];
            }else{
                storage[primaryIndex] = new boolean[secondaryBucket];    //initialize a secondary bucket of 1000 to the storage
            }
            
        }
        int secondaryIndex = getSecondaryHash(key); //if not null, then go to secondary storage
        storage[primaryIndex][secondaryIndex] = true; //add the key to seondary bucket
        
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;

        
    }
    
    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
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