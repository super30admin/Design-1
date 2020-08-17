// Time Complexity : O(1)
// Space Complexity : O(1) Because 1000001 is a constant and it doesnt grow
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach 
class MyHashMap {
    int[] mapArray;
    /** Initialize your data structure here. */
    public MyHashMap() {
        mapArray=new int[1000001]; // to access 0-1000000 keys we give array size 1000001
        Arrays.fill(mapArray,-1);  // assigning default value as -1 to all keys
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        mapArray[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return mapArray[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        mapArray[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */