// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class MyHashSet {

    private boolean[][] storage; //Initialize primary and second structure. Primary will be a pointer to the seond one. Secondary will be boolean
    private int buckets; //Variable to store the size of primary data structure
    private int bucketItems; //Variable to store the size of the secondary data structure

    public MyHashSet() {
        this.buckets = 1000; //Square root of the maximum key size is taken as the length of primary
        this.bucketItems = 1000; //and secondary data structures to ensure balance in terms of space
        this.storage = new boolean[buckets][]; //Initialize the size of the primary data structure alone. Secondary will be initialized on the go only if a corresponding key is added
    }

    //Double Hashing
    private int hashFunc1(int key){
        return key % buckets; //Hash function for primary ds. Every bucket, except 0th can store 1000 keys. For example, 1st bucket will store keys such as 1001, 2001, 3001...
    }

    private int hashFunc2(int key){
        return key / bucketItems; //Hash function for secondary ds. '/' is used to avoid collision. 1001/1000 = 1, will be assigned to the first bucket, 2001 will be assigned to the second and so on
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void add(int key) {
        int bucket = hashFunc1(key); //Get the bucket for the input key (Corresponding location in primary ds)
        int bucketItem = hashFunc2(key); //Get the location of the key on the secondary ds
        if(storage[bucket] == null){ //Using null for the check because primary bucket is a pointer. Data Structure inside a Data Structure is always a pointer!
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];  //If the key belongs to the 0th bucket, size of secondary ds should be 1001 to accommodate 10^6th key
            } else {
                storage[bucket] = new boolean[bucketItems]; //If not, size of the secondary ds is 1000
            }
        }
        storage[bucket][bucketItem] = true; //Flag the corresponding location as true
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void remove(int key) {
        int bucket = hashFunc1(key);
        int bucketItem = hashFunc2(key);

        if(storage[bucket] == null) 
            return; //Return if there is no item
        storage[bucket][bucketItem] = false; //Mark the corresponding location as false if key is stored previously
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public boolean contains(int key) {
        int bucket = hashFunc1(key);
        int bucketItem = hashFunc2(key);
        if(storage[bucket] == null)
            return false; //Return false if the secondary ds itself is not initialized
        return storage[bucket][bucketItem]; //Return true or false corresponding to the location on secondary ds
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */