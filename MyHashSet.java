
// Did this code successfully run on Leetcode : Yes
// We use a primary array as the main bucket, where the first hash function 
// determines the index for storing an element. To handle collisions, each 
// primary index can have its own secondary bucket. A secondary hash function 
// is used to calculate the index inside this secondary bucket. 
// This ensures that each element is mapped to one specific position in its 
// corresponding secondary bucket, avoiding collisions. 
// Instead of storing the integer values directly, we use a boolean (true/false) 
// to indicate the presence of an element, which helps in saving memory.
class MyHashSet {
    int bucket;
    int bucketItems;
    boolean [][] storage;

    public MyHashSet() {
        this.bucket=1000;
        this.bucketItems=1000;
        this.storage= new boolean[bucket][];
        
    }

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Primary Hash Function
    public int hash1(int key){
        return key%bucket;
    }

    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Secondary Hash Function
    public int hash2(int key){
        return key/bucket;
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Add function to add an element to the HashSet
    public void add(int key) {
        int primaryIndex= hash1(key);
        if(storage[primaryIndex]== null)
        {
            if(primaryIndex==0)
            {
                storage[primaryIndex]= new boolean [bucketItems+1];
            }
            else
            {
                storage[primaryIndex]= new boolean [bucketItems];
            }
        }
        int secondaryIndex= hash2(key);
        storage[primaryIndex][secondaryIndex]= true;

        
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void remove(int key) {
        int primaryIndex= hash1(key);
        if(storage[primaryIndex]== null)
        {
            return;
        }
        int secondaryIndex= hash2(key);
        storage[primaryIndex][secondaryIndex]= false;
        
    }
    
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public boolean contains(int key) {
        int primaryIndex= hash1(key);
        if(storage[primaryIndex]== null){
            return false;
        }
        int secondaryIndex= hash2(key);
        return storage[primaryIndex][secondaryIndex];
        
        
    }
}
