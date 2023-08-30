/*Time Complexity
  Add:O(1)
  Remove:O(1)
  Contains:O(1)
  
  Space Complexity:O(1)

*/
class MyHashSet {
    int buckets; //Primary Bucket
    int bucketItems; //Secondary Bucket 
    boolean[][] storage; //Storing Boolean value i.e True or False

    public MyHashSet() {
        this.buckets=1000; //Size of buckets 10^3
        this.bucketItems=1000; //Size of bucketItems 10^3
        storage=new boolean[buckets][];
    }

    private int getBucket(int key){
        return key % buckets; //Return index for buckets
    }
    
    private int getBucketItem(int key){
        return key/bucketItems; //Return index for bucketItems

    }
    public void add(int key) {
        int bucket= getBucket(key); //Get key for bucket
        int bucketItem= getBucketItem(key);//Get key for bucketItem
        if(storage[bucket]==null){ //if there is null value in the storage 
        if(bucket==0){
            storage[bucket]=new boolean [bucketItems+1];
        }
        else{
            storage[bucket]=new boolean[bucketItems]; //Create an bucketItems array
         }
        }
        storage[bucket][bucketItem]=true; //Set the value to True
    }
    
    public void remove(int key) {
        int bucket= getBucket(key); //Get key for bucket
        int bucketItem=getBucketItem(key); //Get key for bucketItem
        if(storage[bucket]==null){ //If there is null value in storage
            return;        //Return 
        }
        storage[bucket][bucketItem]=false ;//Set the value to false 
    }
    
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null){
            return false; //If it doesn't contain key it return false
        }
        return storage[bucket][bucketItem]; //If it contains key it returns True
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
