// Time Complexity : For the put operation, in case if arrays are initialized at index received from hash 1,
// Put: O(1); Get: O(1); Delete: O(1); if there is no array created or initialized at that index, a new array is created which can take about sq root of n, but as for less values it is negligible so in ideal case we can consider O(1)
// Space Complexity : taken by hash map is O(n) as we need to create a 1000 element array for each hash 1 index and max could be 1000*1000 = n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I considered that nested array would be auto initialized, due to which wrong answer was coming. Once I initialized the values with -1 it worked fine

// Your code here along with comments explaining your approach
class MyHashMap {
    int[][] map;
    
    // hash function 1 to identify ideal position of value by performing modulus of key received
    public int hashLoc(int key) {
        return key%1000;
    }
    
    // hash function to arrange an offset position in nested array to place the key's value by dividing by 1000
    public int hashOffset(int key) {
        return key/1000;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        //initialized the array with only 1000 indexes
        map = new int[1000][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // identify nested array position on primary array
        int row = hashLoc(key);
        
        // identify position where to insert the value to the key
        int col = hashOffset(key);
        
        // in case the nested array is not present
        if(map[row]==null){
            // create a new array on primary array at row index
            map[row] = new int[1001];
            // initialize nested array with -1 as there is no value assigned to them
            for(int i=0; i<map[row].length; i++) {
                map[row][i] = -1;
            }
        }
        // assign the value to specific nested array element
        map[row][col] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        // similar to put, identifying the location of element to retrieve it
        int row = hashLoc(key);
        int col = hashOffset(key);
        // if the row itself does not contain a nested array to search for element return -1
        if(map[row]==null) {
            return -1;
        } else {
            // if element position is present return element
            return map[row][col];
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // similar to put, identifying the location of element to retrieve it
        int row = hashLoc(key);
        int col = hashOffset(key);
        // if the row itself does not contain a nested array to search for element return
        if(map[row]==null) {
            return;
        } else {
            // if element position is present assign it to -1
            map[row][col] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */