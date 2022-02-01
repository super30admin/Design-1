import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding why -1 used in .fill and remove

class MyHashMap {

    // creating int array based on constraints, 10^6
    int[] hashMap = new int[10000000];
    
    public MyHashMap() {
        // initializing all values from -1
        Arrays.fill(hashMap, -1);
    }
    
    public void put(int key, int value) {
        hashMap[key] = value;
    }
    
    public int get(int key) {
        return hashMap[key];
    }
    
    public void remove(int key) {
        hashMap[key] = -1;
    }
}