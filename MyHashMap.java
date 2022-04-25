// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Arrays;

class MyHashMap {
    //Creating an array to store elements. Here, key is index of the array and value is actual element at respective index
    int[] map;
    int size = 1;
    public MyHashMap() {
        map = new int[size];
        Arrays.fill(map, -1);
    }
    
    public void put(int key, int value) {
        //If Key is greater than current size of the array then we create new array with key size then copy all the values from previous array
        if (key >= size) {
            int[] newMap = new int[key + 1];
            Arrays.fill(newMap, -1);
            System.arraycopy(map, 0, newMap, 0, size);
            size = newMap.length;
            map = newMap;
        }
        //Stores value at key index
        map[key] = value;
    }
    
    public int get(int key) {
        //Returning value at particular index
        if (key >= size) return -1;
        return map[key];
    }
    
    public void remove(int key) {
        //Making -1 means removing the element from the array
        if (key >= size) return;
        map[key] = -1;
    }
}