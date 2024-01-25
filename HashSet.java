// Time Complexity : O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to brush up the concepts again so watched yestereday lecture


// Your code here along with comments explaining your approach

class MyHashSet {
    private int buckets;
    private int bucketItems;
    private boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000; // based on the input size of 10^6, we will sqrt the upper limit
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    
    //hash function to get the index of the primary array(buckets)
    private int bucket(int key){
        return key%buckets;
    }

    //hash function to get the index of the nested array(bucketItems)
    private int bucketItem(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int i = bucket(key);

        if(storage[i] == null){
            if(i == 0){ // to cater to the edge case when 10^6 % 1000 results in i = 0
               storage[i] = new boolean[bucketItems+1]; // 10^6 / 1000 results in bucketItem = 1000, which should be present.
            }
            else{
                storage[i] = new boolean[bucketItems];
            }          
        }
        storage[i][bucketItem(key)] = true;
    }
    
    public void remove(int key) {
        int i = bucket(key);

        if(storage[i] == null){
            return;
        }
        storage[i][bucketItem(key)] = false;
    }
    
    public boolean contains(int key) {
        int i = bucket(key);

        if(storage[i] == null){
            return false;
        }
        return storage[i][bucketItem(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */