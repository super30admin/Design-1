// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MyHashSet {
    private int buckets = 1000; //creating two buckets to handle collisions
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        table = new boolean[buckets][]; //initialising them
    }

    public int hash(int key) { //first hashing function
        return key % buckets;
    }

    public int pos(int key) { //second hashing function
        return key / buckets;
    }

    public void add(int key) { //for adding, first performing hashing and getting the index
        int hashkey = hash(key);

        if (table[hashkey] == null) { //checking if there is no bucket under the index, if no bucket create a new one
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true; //making that value as true
    }

    public void remove(int key) { //to remove, first perform hashing and getting the index
        int hashkey = hash(key);

        if (table[hashkey] != null) // /checking if there is no bucket under the index, if true then return nothing it means there is no key to remove.
            table[hashkey][pos(key)] = false; //if yes then make that value as false
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */