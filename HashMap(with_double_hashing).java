// HashMap.java is here where we use liner chaining of the elements;
// Tried Suing Duble Hashing was not able to achieve the same;

 int[][] storage;
    int buckets;
    int bucketItems;
    
    public MyHashMap() {
        buckets=1000;
        bucketItems=1000;
        storage=new int[buckets][];
        int i;
        for(i=0;i<buckets;i++){
            storage[i][0]=-1;
        }
    }
    
    public int getBucket(int key){
        return key%buckets;
    }
    
    public int getBucketItem(int key){
        return key/buckets;
    }
    
    public void put(int key, int value) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        
        if(storage[bucket][0]==-1){
            if(bucket==0){
                storage[bucket]=new int[bucketItems+1];
                int j;
                for(j=0;j<bucketItems;j++){
                    storage[bucket][j]=-1;
                }
            }
            else{
                storage[bucket]=new int[bucketItems];
                int j;
                for(j=0;j<bucketItems;j++){
                    storage[bucket][j]=-1;
                }
            }
        }
        storage[bucket][bucketItem]=value;
    }
    
    public int get(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        
        if(storage[bucket]==-1){
            return storage[bucket];
        }else if(storage[bucket][bucketItem]==-1){
            return storage[bucket][bucketItem];
        }else{
            return storage[bucket][bucketItem];
        }
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==-1){
            return;
        }else{
            storage[bucket][bucketItem]=-1;
        }
    }

Error Message:
Line 51: error: bad operand types for binary operator '==' [in MyHashMap.java]
        if(storage[bucket]==-1){
                          ^
  first type:  int[]
  second type: int
Line 52: error: incompatible types: int[] cannot be converted to int [in MyHashMap.java]
            return storage[bucket];
                          ^
Line 63: error: bad operand types for binary operator '==' [in MyHashMap.java]
        if(storage[bucket]==-1){
                          ^
  first type:  int[]
  second type: int
3 errors
