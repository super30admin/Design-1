// Time Complexity : O(1) for all operations.
// Space Complexity : O(n) , where n is the total number of keys.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Hashset is created using 2d array of boolean.
// Boolean is used insted of integer to reduce the space complexity.
// We generate 2 hash methods to one to generate primary hash index using %,
// other to generate secondary hash index using / .
class MyHashSet {

    //storage to store the hashset
    boolean [][] storage;
    //Primary array size
    int pSize;
    //Secondary array size
    int sSize;

    public MyHashSet() {
        this.pSize = 1000;
        this.sSize = 1000;
        this.storage = new boolean[pSize][];
    }

    //Hashing to generate the primary Index
    private int getPHashIndex(int key){
        return key % pSize;
    }

    //Hashing to generate the secondary Index
    private int getSHashIndex(int key){
        return key / sSize;
    }

    //gets the primary hash index of the key
    //checks if there is any value at the index or not:
    //if no, initialize secondary array and then add the value on the secondary hash index.
    //if present, do not initialize again, just add the value on the secondary hash index.
    public void add(int key) {
        int pIndex = getPHashIndex(key);
        if(storage[pIndex] == null){
            //to handle edge case
            if(pIndex == 0){
                storage[pIndex] = new boolean[sSize+1];
            }else{
                storage[pIndex] = new boolean[sSize];
            }

        }
        int sIndex = getSHashIndex(key);
        storage[pIndex][sIndex] = true;
    }

    // similar to add function
    // checks if there is any value at the primary hash index or not:
    // if no just return we dont have anything to remove
    // if yes return the value on the secondary hash index.
    public void remove(int key) {
        int pIndex = getPHashIndex(key);
        if(storage[pIndex] == null){
            return;
        }
        int sIndex = getSHashIndex(key);
        storage[pIndex][sIndex] = false;
    }

    // if no value at the primary hash index,the hashset does not contain the key
    // if value present, return the value on the secondary hash index, true/false
    public boolean contains(int key) {
        int pIndex = getPHashIndex(key);
        if(storage[pIndex] == null){
            return false;
        }
        int sIndex = getSHashIndex(key);
        return storage[pIndex][sIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */