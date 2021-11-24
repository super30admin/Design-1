// time complexity is O(1)
//Space complexity, it can store 10^6 elements so O(1)
//it ran on leet code
//
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;//taking sq root of the required
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    private int getBucket(int key){//return the location on the first row of array
        return key%buckets;
    }
    private int getBucketItem(int key){//returns location on the second array that we decalre later
        return key/buckets;
    }
   
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){//if nothin in the col is present we create new array
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];//0-10^6 there are 10^6+1 element, its for the extra element i.e. 10^6
            }else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;//array has been created
    }
   
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket][bucketItem] == true){
            storage[bucket][bucketItem] = false;
        }
    }
   
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}