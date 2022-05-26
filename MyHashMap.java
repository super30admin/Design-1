import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
//Approach: I created an array and initialized it to the size 1000001.
//This is so that we can include all the values including the upper and lower bounds.
//I then filled my array with default values of -1 as it is representative of no mapping for a given key.
//The put and get functions are pretty straigtforward and when we remove a certain key, the program assigns the value -1 at thet specific key.

class MyHashMap {
    private int [] map;

    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(30,25);
        obj.put(25,30);
        int param_2 = obj.get(30);
        int param_3 = obj.get(25);
        System.out.println(param_2);
        System.out.println(param_3);
        obj.remove(30);
        int param_4 = obj.get(30);
        int param_5 = obj.get(25);
        System.out.println(param_4);
        System.out.println(param_5);
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */