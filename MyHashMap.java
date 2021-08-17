// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

import java.util.Arrays;

class MyHashMap {
     int[] array = new int[100000];

    public MyHashMap() {
        Arrays.fill(array,-1);
    }
    
    public void put(int key, int value) {
        int index = key%100000;
        array[index] = value;
    }
    
    public int get(int key) {
        int index = key%100000;
        return array[index];
    }
    public void remove(int key) {
         int index = key%100000;
         array[index] =-1;
    }
}