// Average Time Complexity :put-O(1)
// Worst Time Complexity :  put-O(n)- this will occur only 1000 times out of 10^6 times.
//                         get-O(1), remove-O(1)
// Space Complexity : O(n) where n is the 10^6 here or maximum number of input possible
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : the worst case for put() operation is still O(n),
//                                           although it will be very rare. I am not able to get fully O(1) for it

class MyHashMap {

    // a 2-D array reprsenting our set
    int[][] set;
    //represents the hash1 locations
    int bucket;
    //represents the hash2 locations
    int bucketItem;

    // Initializing
    public MyHashMap() {
        //since there can be at max 10^6 elements and each bucket can hold 1000 elements
        // 10^3 * 10^3 = 10^6, hence we have 1000 buckets
        this.bucket = 1000;
        //initilizing our set
        this.set = new int[this.bucket][];
    }

    // first hash function
    public int hash1(int key){
        return key%1000;
    }
    //second hash function
    public int hash2(int key){
        return key/1000;
    }

    // puts a key-value pair in hashMap
    public void put(int key, int value) {
        //fetching bucket index from the key
        int bucket = this.hash1(key);
        //checking if the bucket doesn't exists
        if(this.set[bucket]==null){
            //create a bucket with 1000 length
            this.bucketItem = 1001;
            this.set[bucket] = new int[this.bucketItem];

            //initializing initial bucket item values to -1
            for(int i=0; i<this.bucketItem; i++){
                this.set[bucket][i] = -1;
            }
        }
        //get item index within bucket
        int bucketItem = this.hash2(key);
        //mark item as available
        this.set[bucket][bucketItem] = value;
    }

    //gets a value based on key from HashMap
    public int get(int key) {
        //fetching bucket index
        int bucket = this.hash1(key);
        //checking if the bucket doesn't exists
        if(this.set[bucket]==null){
            return -1;
        }
        //get key index within bucket
        int bucketItem = this.hash2(key);
        //return value at the index
        return this.set[bucket][bucketItem];
    }

   //remove a key-value pair from HashMap
    public void remove(int key) {
        //fetching bucket index
        int bucket = this.hash1(key);
        //checking if the bucket doesn't exists
        if(this.set[bucket]==null){
            return;
        }
        //get key index within bucket
        int bucketItem = this.hash2(key);
        //mark current location as empty
        this.set[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */