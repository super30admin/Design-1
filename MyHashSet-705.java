// We implement HashSet using Double Hasing, where we create a 2D array.
// It would not be efficient space complexity wise to create a single array of 10^6 size 
// thus to deal with that problem we create 2D array so that we initialize the storage array with
//size 1000 and need basis whenever if needed we extend 
//the 2D array based on key input we extend it to 2D array. 
class MyHashSet {
       // buckets is the size of the first part of the storage array(also can be called as primary array)
       int buckets;
       // Whenever we have input which satisfies the above bucket condition then we extend 
       //the 1D array to 2D array of size 1000(can be referred as secondary array). 
       //the 1D array consists of address of second array.
       int bucketItems;
       // The 2D array to store the values
       boolean [][] storage; 

    // Constructor for class MyHashSet
    public MyHashSet() {

        this.buckets = 1000; // intilize the size of first part of the storage array
        this.bucketItems=1000; // intialize the second part of the storage array
        this.storage = new boolean[buckets][]; // Initizing the storage 2D array
    }

    // This is a private method which returns the bucket value for the storage array
    // Method to get first value for Double Hashing
    // Time Complexity : O(1) 
    private int getBucket(int key) // returns int
    {
       return key%this.buckets; 
    }

   // This method gives the second part of the 2D array or this the second method for double hasing
   // in the code
   // Method to get second value for Double Hasing
   // Time Complexity : O(1)
    private int getBucketItems(int key) // returns int
    {
        return key/this.bucketItems;
    }

   // This method adds the key element to the storage array
   // Time Complexity: O(1)
    public void add(int key) {

        int bucket = getBucket(key); // Check bucket value for specific key value
        int bucketItem = getBucketItems(key); // Check bucketItem for specific key value
        if (storage[bucket]==null) // Checks if the storage[bucket] contains the address of the secondary array
        {
            if(bucket==0)
            {
                storage[bucket] = new boolean[this.bucketItems+1]; // If the bucket is 0 then extra cell is added in secondary array to cover the edge case of 10^6
            }
            else {
                storage[bucket] = new boolean[this.bucketItems]; // extend the primary array to seconday array where primary array contains the address of secondary array
            }
        }
        storage[bucket][bucketItem] = true;        
    }
    
    // This method is used to remove the key from the storage array
    // As per our code's logic if a key is removed we change the specific index based on our logic
    // from true to false
    public void remove(int key) {
      int bucket = getBucket(key); // Check bucket value for specific key value
      int bucketItem = getBucketItems(key); // Check bucketItem for specific key value
      if (storage[bucket]!=null) // Checks if the storage[bucket] contains the address of the secondary array
      {
        storage [bucket][bucketItem]=false;
      }  
    }
    
    public boolean contains(int key) { // returns true if the storage 2D array contains the key or false if it does not
        int bucket = getBucket(key); // Check bucket value for specific key value
        int bucketItem = getBucketItems(key); // Check bucketItem for specific key value
        if(storage[bucket]==null){// Checks if the storage[bucket] contains the address of the secondary array
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
