// Time Complexity : add(), remove(), contains() -> O(1) average and worst case
// Space Complexity : O(N), where N is the number of possible keys (up to 10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Here is code with comments: Instead of utilizing pre-installed hash table libraries, I'm creating a HashSet from scratch. This method employs two hashes: one for the primary bucket and another for the secondary bucket. To conserve space,I use lazy initialization, which delays the initialization of the inner boolean arrays.

class MyHashSet {

    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {

        this.primaryBuckets=1000;
        this.secondaryBuckets = 1000;
        this.storage= new boolean[primaryBuckets][];
    }

    private int getPrimaryHash(int key){
        return key % primaryBuckets;
    }

    private int getSecondaryHash(int key){
        return key / secondaryBuckets;
    }
    
    public void add(int key) {
        int  primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex==0){
                storage[primaryIndex] = new boolean[secondaryBuckets+1];
            }
            else{
                storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex =getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
        
    }
}

