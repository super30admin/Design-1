// Time Complexity : O(1) - to add, remove and contains
// Space Complexity : BestCase: O(buckets) - outer array, Worstcase - O(buckets)*O(bucketItems) i.e. 1000*1001
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not as such

// Your code here along with comments explaining your approach
//Designed hashset using 2D array because of fixed range of keys given. 
//Also was able to obtains O(1) TC to add, remove and contains 


class MyHashSet {
    private final int buckets = 1000;
    private final int bucketItems = 1001;
    private boolean [][]storage;
    private int HashFunc1(int key){
        return key % buckets;
    }

    private int HashFunc2(int key){
        return key / buckets;
    }

    public MyHashSet() {
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int idx1 = HashFunc1(key);
        int idx2 = HashFunc2(key);

        if(storage[idx1] == null)
            storage[idx1] = new boolean[bucketItems];
        storage[idx1][idx2] = true;
    }
    
    public void remove(int key) {
        int idx1 = HashFunc1(key);
        int idx2 = HashFunc2(key);

        if(storage[idx1] != null)
            storage[idx1][idx2] = false;
    }
    
    public boolean contains(int key) {
        int idx1 = HashFunc1(key);
        int idx2 = HashFunc2(key);

        return storage[idx1]!=null && storage[idx1][idx2];
        
    }
}
