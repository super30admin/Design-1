import java.util.Arrays;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MyHashMap {
    private int[][] map;
    int outerSize;
    int innerSize;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000][];
        outerSize = 1000;
        innerSize = 1000;
    }
    
    private int outerHash(int key){
        return key % outerSize;
    }
    
    private int innerHash(int key){
        return key / innerSize;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int outIndex = outerHash(key);
        int inIndex = innerHash(key);
        if(map[outIndex] == null){
            if(outIndex == 0){
                map[outIndex] = new int[innerSize+1];
            }
            else{
                map[outIndex] = new int[innerSize];
            }
            Arrays.fill(map[outIndex], -1);
        }
        map[outIndex][inIndex] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int outIndex = outerHash(key);
        int inIndex = innerHash(key);
        if(map[outIndex] == null) return -1;
        return map[outIndex][inIndex];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int outIndex = outerHash(key);
        int inIndex = innerHash(key);
        if(map[outIndex] == null) return;
        map[outIndex][inIndex] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */