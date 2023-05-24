// Time Complexity : O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    // Implemented using double hashing method 
    //Instead of using 1D array, we use 2D arrays with the primary array of size 10^3 and secondary array of size 10^3 .(Taking the squareroot of max value 10^6)
    boolean storage[][];// use boolean as it takes 2 bytes less space instead of int
    int buckets;
    int bucketItems;
 
     public MyHashSet() {
        buckets = 1000;// size of primary array
        bucketItems = 1000;// size of secondary array
        storage  = new boolean[buckets][]; 
     }
     
    //first hashing function logic
     public int getBucket(int key){
     return key % buckets;
     } 
 //second hashing function logic
     public int getBucketItem(int key){
     return key/bucketItems;
     }
     public void add(int key) {
         int bucket = getBucket(key);
         int bucketItem = getBucketItem(key);
         if (storage[bucket] == null){
             if(bucket == 0){
            //At index 0 of the primary array we would need to store 0-1000 values hence 1000 + 1
                storage[bucket] = new boolean[bucketItems + 1];
             }
             else{
                  storage[bucket] = new boolean[bucketItems];
             }
              
         }
        storage[bucket][bucketItem] = true;
     }
     
     public void remove(int key) {
          int bucket = getBucket(key);
         int bucketItem = getBucketItem(key);
         //check if the element is present in index
         if(storage[bucket] == null){
             return;
         }
         else{
            //set it to false indicating not present
             storage[bucket][bucketItem] = false;
         }
     }
     
     public boolean contains(int key) {
        int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);
         if(storage[bucket] != null){
                 return  storage[bucket][bucketItem];
             }
             return false;
         }
   }
 
 /**
  * Your MyHashSet object will be instantiated and called as such:
  * MyHashSet obj = new MyHashSet();
  * obj.add(key);
  * obj.remove(key);
  * boolean param_3 = obj.contains(key);
  */
