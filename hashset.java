class MyHashSet {
    
    boolean[][] storage;
    int bucket;
    int bucketItems;
    

    public MyHashSet() 
    {
        bucket=1000;
        bucketItems=1000;
        storage = new boolean[bucket][];
        
    }
    
    private int getbucket(){
        return bucket%1000;
    }
    private int getbucketItems(){
        return bucketItems/1000;
    }
    public void add(int key) {
        int bucket= getBucket(key);
        int bucketItems= getBucketItems(key);
        if (storage[bucket]==null)
        {
            if(bucket==0)
            {
                storage[bucket]=new boolean[bucketItems+1];
                
            }
            else{
                storage[bucket]=new boolean[bucketItems];
            }
        }
    }
    
    public void remove(int key) 
    {
         Int bucket= getbucket(key);
        Int bucketItems= getbucketItems(key);
        if(storage[bucket]==null){
            return false;
        }
       storage[bucket][bucketItems]=false;
    }
    
    public boolean contains(int key) 
    {
     Int bucket= getbucket(key);
        Int bucketItems= getbucketItems(key);
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem];    
    }
}