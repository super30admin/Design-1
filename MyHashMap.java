// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
    
    int[] myHashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        myHashMap = new int[10000001];
        Arrays.fill(myHashMap,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        myHashMap[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return myHashMap[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        myHashMap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */