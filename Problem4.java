// Time Complexity : put()-O(1) get()-O(1) remove()-O(1)
// Space Complexity : Worst Case- O(n) - 10^6
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It took some time for me to think about which data structure to use.


// Your code here along with comments explaining your approach

class MyHashMap {
    
    //Storage array declaration
    private int storage[][];
    private int buckets;
    private int bucketItems;

    public MyHashMap() {
        //Initialising values
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new int[buckets][];
    }
    
    //Hash function 1
    private int bucket(int key) {
        return key%buckets;
    }
    
    //Hash function 2
    private int bucketItem(int key) {
        return key/bucketItems;
    }
    
    public void put(int key, int value) {
        int bucket = bucket(key); //hash value 1
        int bucketItem = bucketItem(key); //hash value 2
        if(storage[bucket] == null) { //check whether the bucket is intialised or not
            if(bucket == 0) {
                storage[bucket] = new int[ bucketItems+1 ]; // to handle 10^6 case
            } else {
                storage[bucket] = new int[ bucketItems ]; // all other cases
            }
            Arrays.fill(storage[bucket],-1); //default value in leetcode (if the element is not present we should return -1)
        }
        storage[bucket][bucketItem] = value; //storing the value
    }
    
    public int get(int key) {
        int bucket = bucket(key); //hash value 1
        int bucketItem = bucketItem(key); //hash value 2
        if(storage[bucket]==null) { return -1; } //check whether the bucket is intialised or not
        else { return storage[bucket][bucketItem]; } //return value
    }
    
    public void remove(int key) {
        int bucket = bucket(key); //hash value 1
        int bucketItem = bucketItem(key); //hash value 2
        if(storage[bucket]==null) { return; } //check whether the bucket is intialised or not
        storage[bucket][bucketItem] = -1; //modifying the value
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */