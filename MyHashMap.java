// Time Complexity : Put: O(1); Get: O(1); Delete: O(1); 
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I considered that nested array would be auto initialized, due to which wrong answer was coming. Once I initialized the values with -1 it worked fine

// Your code here along with comments explaining your approach
class MyHashMap {
    int[][] map;
  
    public int hashLoc(int key) {
        return key%1000;
    }

    public int hashOffset(int key) {
        return key/1000;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
     
        int row = hashLoc(key);
        int col = hashOffset(key);
   
        if(map[row]==null){
            map[row] = new int[1001];
            for(int i=0; i<map[row].length; i++) {
                map[row][i] = -1;
            }
        }
        map[row][col] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int row = hashLoc(key);
        int col = hashOffset(key);
        if(map[row]==null) {
            return -1;
        } else {
            return map[row][col];
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int row = hashLoc(key);
        int col = hashOffset(key);
        if(map[row]==null) {
            return;
        } else {
            map[row][col] = -1;
        }
    }
}