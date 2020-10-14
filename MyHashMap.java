package Day1;

class MyHashMap {
    
    // Time Complexity: O(1)
    // All operations involved array(1-d/2-d) put, get or remove which has O(1) complexity.
    
    // Space Complexity: O(n) 
    //  Worst case scenario when all 1000000 elements are initialized in the 2-d boolean storage array.
   
    // Did this code successfully run on Leetcode : Yes
    
    // Any problem you faced while coding this : No
    
     int buckets;
     int bucketSize;
     int[][] storage; 

    
    /** Initialize your data structure here. */
    // Initialized a 2d array of colsize = underroot of permissible Max value, i.e. 1000000.
    // rowsize declared in a variable but yet not initialized in array
    // rowsize will be initialized when a value has to be inserted on that specific index.
    public MyHashMap() {
       buckets = 1000;
       bucketSize = 1001;
       storage = new int[buckets][];
    }
    
    /** value will always be non-negative. */
    // get hashcodes of the new key using both the hashfunctions
    // check if a value has been inserted at hashValue1 index in 'storage' array
    // if yes => array rowsize has also been initialized already => just insert 'value' from function arg on array element indexed at (hashvalue1 , hashvalue2).
    // if no => initialize rowSize array on col index = hashValue1 => then insert 'value' from function arg on array element indexed at (hashvalue1 , hashvalue2).
    public void put(int key, int value) {
    
        int hashValue1 = hashFunction1(key);
        int hashValue2 = hashFunction2(key);

        if(storage[hashValue1] == null){
            storage[hashValue1] = new int[bucketSize];
            Arrays.fill(storage[hashValue1], -1);
        } 
        
        storage[hashValue1][hashValue2] = value; 
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
     // get hashcodes of the new key using both the hashfunctions which will yield two different values
   // check if a value has been inserted at hashValue1 index in 'storage' array
    // if yes, return that value.
    // if no, return -1 as mentioned in prob statement.
    public int get(int key) {
        
        // get hashcode of the new object
        // use this hashcode as index in 'map' array
        int hashValue1 = hashFunction1(key);
        int hashValue2 = hashFunction2(key);
        
        if (storage[hashValue1] != null )
           return storage[hashValue1][hashValue2];
        
        return -1;  
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    // get hashcodes of the new key using both the hashfunctions which will yield two different values
    // check if a value has been inserted at hashValue1 index in 'storage' array
    // if yes, set the value back to -1.
    public void remove(int key) {
        
        // get hashcode of the new object
        // use this hashcode as index in 'map' array
        int hashValue1 = hashFunction1(key);
        int hashValue2 = hashFunction2(key);
          
        if (storage[hashValue1] != null)
          storage[hashValue1][hashValue2] = -1;    
    }
    
    // first hashcode function to return hashcode for a numeric input
    private int hashFunction1(int num){
        return Integer.hashCode(num) % 1000;      
    }
    
    // second hashcode function to return hashcode for a numeric input
    private int hashFunction2(int num){
        return Integer.hashCode(num) / 1000;      
    }   
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */