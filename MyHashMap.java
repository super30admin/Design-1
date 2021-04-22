// Average Time Complexity :put-O(1)
// Worst Time Complexity :  put-O(n)- this will occur only 1000 times out of 10^6 times.
//                         get-O(1), remove-O(1)
// Space Complexity : O(n) where n is the 10^6 here or maximum number of input possible
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : the worst case for put() operation is still O(n),
//                                           although it will be very rare. I am not able to get fully O(1) for it
class MyHashMap {


    int[][] set;
    int bucket, bucketItem;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.bucket = 1000;
        this.set = new int[this.bucket][];
    }

    public int hash1(int key){
        return key%1000;
    }

    public int hash2(int key){
        return key/1000;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = this.hash1(key);
        if(this.set[bucket]==null){
            this.bucketItem = 1001;
            this.set[bucket] = new int[this.bucketItem];
            //initializing array value to -1
            // this is causing it to run in O(n) but I need to do put() in O(1)
            // if I don't do this, then all values of nested array is initialized to Zero and when we make a get() call
            // even though a key might not have been put(), returns zero on get() which is not valid. it should be null or -1
            for(int i=0; i<this.bucketItem; i++){
                this.set[bucket][i] = -1;
            }
        }
        int bucketItem = this.hash2(key);
        this.set[bucket][bucketItem] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = this.hash1(key);
        if(this.set[bucket]==null){
            return -1;
        }
        int bucketItem = this.hash2(key);

        return this.set[bucket][bucketItem];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = this.hash1(key);
        if(this.set[bucket]==null){
            return;
        }
        int bucketItem = this.hash2(key);
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