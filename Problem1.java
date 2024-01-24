// https://leetcode.com/problems/design-hashset/
// Time Complexity :
//      add: O(1)
//      remove: O(1)
//      contains: O(1) 

// Space Complexity :
//      add: O(1)
//      remove: O(1)
//      contains: O(1) 

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
//      To what scope do we define space complexity?
//      In this case we are using an array to store the elements,
//      So, would I say that the space complexity of the class is O(N) where N is the number of input elements?


// Your code here along with comments explaining your approach


class Problem1 {
    // buckets - size of primary array to store keys
    // bucketItems - size of each nested array
    int buckets;
    int bucketItems;
    boolean[][] store; 

    private int getPrimaryHash(int key){
        return key%buckets;
    }

    private int getSecondaryHash(int key){
        return key/bucketItems;
    }

    public Problem1() {
        // Primary array length is sq root of upper limit of range
        // In this case root(10^6)=1000
        buckets=1000;
        bucketItems=1000;
        store = new boolean[buckets][];
    }
    
    public void add(int key) {
        int primaryHash=getPrimaryHash(key);
        int secondaryHash=getSecondaryHash(key);
        if(store[primaryHash]==null){
            // the buckets[0] will have an edge case when key=UPPER LIMIT
            // we need one space for one extra element here
            if(primaryHash==0){
                store[primaryHash]=new boolean[bucketItems+1];
            }else{
                store[primaryHash]=new boolean[bucketItems];
            }
        }
        store[primaryHash][secondaryHash]=true;
    }
    
    public void remove(int key) {
        int primaryHash=getPrimaryHash(key);
        int secondaryHash=getSecondaryHash(key);
        if(store[primaryHash]==null)  return;
        store[primaryHash][secondaryHash]=false;
    }
    
    public boolean contains(int key) {
        int primaryHash=getPrimaryHash(key);
        int secondaryHash=getSecondaryHash(key);
        if(store[primaryHash]==null)  return false;
        return store[primaryHash][secondaryHash];
    }
}
