
/**Time Complexity :
    add>>O(1) as it does in constant time
    remove>>O(1) constant time to retrieve value
    contains>>O(1) constant time to directly get the key
// Space Complexity :
     we used 10^3 space so O(n)
// Did this code successfully run on Leetcode :
     Accepted but not submitted
// Any problem you faced while coding this :   
     At first, I didn't handle the check condition such as while removing check for values if null then return nothing.
// Your code here along with comments explaining your approach**/
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    //Intializing storage and bucket
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage=new boolean[buckets][];
        
    
    }

    //getting the values of the array using key
    public int getBucket(int key){
        return key%buckets;
        
    }

    //getting the values of the secondary array
    public int getBucketItems(int key){
        return key/bucketItems;
    }
    
    //As 0th index will throw an array out of bound while accessing 1000th element hence initialize 0th bucketItems 1001 instead  of 1000.
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItems(key);
        
        if(storage[bucket]==null){

            //To check 0th bucket
            if(bucket==0){
                storage[bucket]=new boolean[bucketItems+1];
            }
            else{
                storage[bucket]=new boolean[bucketItems];
            }
            storage[bucket][bucketItem]=true;
        }
        
    }
    
    public void remove(int key) {
         int bucket=getBucket(key);
        int bucketItem=getBucketItems(key);

        //retun nothing if bucket is empty
        if(storage[bucket]==null){
            return;
        }

        //remove the element by changing the value of boolean array as false
        storage[bucket][bucketItem]=false;
        
    }
    
    public boolean contains(int key) {

        //get the bucket and bucketItem
         int bucket=getBucket(key);
        int bucketItem=getBucketItems(key);
        if(storage[bucket]==null){
            return false;
        }
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