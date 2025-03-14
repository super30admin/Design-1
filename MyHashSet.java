// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Implemeted HashStack using Double Hashing

class MyHashSet {

    boolean[][] storage;
    int primaryBuckets;
    int secondaryBuckets;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][]; //1000*2 = 20000bytes
        // We will not declare secondary array size here, if we do then new Boolean(primaryBuckets)[secondaryBuckets] will be 10(power 6) * 2 = 20M bytes


    }

// We can also switch the % and / in these functions and it will still work. The values in the bukcet will differ though.
    private int getPrimaryHash(int key) {
            return key % primaryBuckets;
    }


    private int getSecondaryHash(int key) {
            return key / secondaryBuckets;
    }
    
    public void add(int key) { // O(1)
        //gives primaryBucket, lets say 2, 2 % 1000 = 2
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null) {
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secondaryBuckets + 1];
            } else {
            storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
        
    }
    
    public void remove(int key) { // O(1)
         int primaryIndex = getPrimaryHash(key);
         if(storage[primaryIndex] == null ){
            return;
         }
         int secondaryIndex = getSecondaryHash(key);
         //If this was an integer array, then we would have initialized it as -1 not 0 because 0 <= key <= 106 and 0 is a valid value and it will create problems.
          storage[primaryIndex][secondaryIndex] = false;
        
    }
    
    public boolean contains(int key) { // O(1)
        int primaryIndex = getPrimaryHash(key);
         if(storage[primaryIndex] == null ){
            return false;
         }
         int secondaryIndex = getSecondaryHash(key);
         
          return storage[primaryIndex][secondaryIndex];
    }
}