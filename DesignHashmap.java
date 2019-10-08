/*
Author: Akhilesh Borgaonkar
Approach: I have implemented using arrays of size MAX. The value is stored at the index key of the array.
Time Complexity: O(1) for get(), put() and remove()
Space Complexity: O(n) where n is number of elements in the array.
LC verified
*/

class MyHashMap {
    
    int MAX = 100000;
    Integer[] map = new Integer[MAX];

    public MyHashMap() {
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;                   //storing value at key-th index of array
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(map[key]==null)                  //checks for presence of key in array
            return -1;
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = null;                    //removing means assigning null to the key-th index
    }
}
