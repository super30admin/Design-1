// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :could just code it using Brute Force Techniques.


// Your code here along with comments explaining your approach
// HashMap Using Brute Force
class MyHashMap {

    /** Initialize your data structure here. */
    int Map[] = new int[769];
    public MyHashMap() {
        for(int i= 0;i<Map.length;i++)Map[i]=-1; //Initialised all the Array with -1 indicating it is empty
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return Map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */