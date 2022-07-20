// Time Complexity : O(1) for all the operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * The approach is to create an array of arrays of 1000 * 1000
 * 
 * Define two basic hash functions to get the first and second index of the 2D array defined above
 * First hash function return a modulo of 1000
 * Second Hash function return a divide by 1000
 * 
 * An extra handling is done for value 0 and 10^6
 */

class MyHashSet {

    private int[][] storage;
    
    public MyHashSet() {
        storage = new int[1000][];
        
        // special case for 0th indexed array
        storage[0] = new int[10001];
        storage[0][0] = -1;
    }
    
    /**
     * For adding a key, we get the first index.
     * If the value at that index is null, then we initialize an array of integers.
     * Set the value at storage[firstIndex][secondIndex]
     */
    public void add(int key) {
        int firstIndex = getModuloHash(key);
        int secondIndex = getInnerIndex(key);
        
        if (storage[firstIndex] != null) {
            storage[firstIndex][secondIndex] = key;
        } else {
            storage[firstIndex] = new int[1000];
            storage[firstIndex][secondIndex] = key;
        }
    }
    
    /**
     * For removing a key, we get the first index.
     * If the value at that index is null, then we do nothing
     * Else Set the value at storage[firstIndex][secondIndex] as -1.
     */
    public void remove(int key) {
        int firstIndex = getModuloHash(key);
        int secondIndex = getInnerIndex(key);
        
        if (storage[firstIndex] != null) {
            storage[firstIndex][secondIndex] = -1;
        }
    }
    
    /**
     * For checking a key, we get the first index.
     * If the value at that index is not null and storage[firstIndex][secondIndex] == key --> return true
     * Else return false
     */
    public boolean contains(int key) {
        int firstIndex = getModuloHash(key);
        int secondIndex = getInnerIndex(key);
        
        if (storage[firstIndex] != null &&
           storage[firstIndex][secondIndex] == key) {
            return true;
        }
        
        return false;
    }
    
    private int getModuloHash(int key) {
        return key % 1000;
    }
    
    private int getInnerIndex(int key) {
        return key / 1000;
    }
}