// Time Complexity : Average case O(1) for get, put and remove operations, in worst case where we have collision, time complexity can be O(N)
// Space Complexity : O(N) where N is size of map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.*;
class MyHashMap{
    private List<HashNode>[] map;
    int size = 10000;
    
    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int idx = key % size;

        //no collision
        if (map[idx] == null){ 
            map[idx] = new LinkedList<>();
        }

        //when we have the same key, we override the value
        for (int i = 0; i < map[idx].size(); i++) {
            if (map[idx].get(i).key == key) {
                map[idx].get(i).value = value;
                return;
            }
        }
        //adding new key value pair
        map[idx].add(new HashNode(key, value));
    }
    
    public int get(int key) {
        int idx = key % size;

        //no data for the given key
        if (map[idx] == null){
            return -1;
        }

        for (int i = 0; i < map[idx].size(); i++) {
            if (map[idx].get(i).key == key){
                return map[idx].get(i).value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key % size;

        //no data for the given key
        if (map[idx] == null){
             return;
        }
        
        for (int i = 0; i < map[idx].size(); i++) {
            if (map[idx].get(i).key == key) {
                map[idx].remove(i);
            }
        }
    }
    
    private class HashNode {
        private int key, value;

        public HashNode(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }
}

public class Sample{
    public static void main(String args[]){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(11, 2);
        System.out.println(hashMap.get(11));
    }
}
