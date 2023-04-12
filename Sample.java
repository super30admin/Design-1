// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;


    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucketAddress = bucketHash(key);
        int bucketItemsAddress = bucketItemsHash(key);
        if(storage[bucketAddress] == null) {
            if (bucketAddress == 0) {
                storage[bucketAddress] = new boolean[bucketItems + 1];
            }
            else {
                storage[bucketAddress] = new boolean[bucketItems];
            }
        }
        storage[bucketAddress][bucketItemsAddress] = true;
    }
  
    public void remove(int key) {
        int bucketAddress = bucketHash(key);
        int bucketItemsAddress = bucketItemsHash(key);

        if(storage[bucketAddress] == null) {
            return;
        }
        storage[bucketAddress][bucketItemsAddress] = false;

    }
    
    public boolean contains(int key) {
        int bucketAddress = bucketHash(key);
        int bucketItemsAddress = bucketItemsHash(key);
        if(storage[bucketAddress] == null) {
            return false;
        }
        return storage[bucketAddress][bucketItemsAddress];

    }
      
    public int bucketHash(int key) {
        return key % 1000;
    }

    public int bucketItemsHash(int key) {
        return key / 1000;
    }

}