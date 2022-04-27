class MyHashMap {
    int buckets;
    int bucketitems;
    int storage[][];
    public MyHashMap() {
        this.buckets=1000;
        this.bucketitems=1000;
        this.storage=new int[buckets][];
    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketitem(int key){
        return key/buckets;
    }
    public void put(int key, int value) {
        int bucket= bucket(key);
        int bucketitem=bucketitem(key);
        if(storage[bucket]==null){
            storage[bucket]=new int[bucketitems+1];
            for(int i=0;i<=bucketitems;i++){
                storage[bucket][i]=1000001;
            }
        }
        
        storage[bucket][bucketitem]=value;
        return;
    }
    
    public int get(int key) {
        int bucket= bucket(key);
        int bucketitem=bucketitem(key);
        if(storage[bucket]==null){
            return -1;
        }
        if(storage[bucket][bucketitem]==1000001){
                return -1;
        }
        return storage[bucket][bucketitem];
    }
    
    public void remove(int key) {
        int bucket= bucket(key);
        int bucketitem=bucketitem(key);
         if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketitem]=1000001;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */