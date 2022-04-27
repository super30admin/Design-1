// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {

    private int[][] storage;
    private int bucket;
    private int bucketItems;
    
    public MyHashMap() {
        this.bucket = 1000;//initialise to sqroot of 10^6 array
        this.bucketItems = 1000;
        this.storage = new int[bucket][];    
    }
    
    private int getBucket(int key){//get location in primary array
        return key % bucket;
    }
    
    private int getBucketItems(int key){//get location in secondary array
        return key / bucketItems;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]= new int[bucketItems+1];//dynamically initialised but we do +1 to accomodate your overflow of 1-10^6 range
                Arrays.fill(storage[bucket],-1);//values will be default -1
            }else{
                storage[bucket]= new int[bucketItems];//dynamically initialized
                Arrays.fill(storage[bucket],-1);
            }
        }
        storage[bucket][bucketItem]=value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            return -1;//if value not present in matrix we return -1
        }
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem] = -1;//we set value to -1 once value is removed
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */