//Time Complexity: O(1) for put, get, remove
//Space Complexity: O(100001) - given input range [0 - 100000 ] 
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Thought of Linked List Approach for memory efficiency .Will try it later

class MyHashMap {

    int[] arr; 
    
    /** Initialize your data structure here. */
    public MyHashMap() {
	// Initialize all values to zero by default
        arr = new int[100001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
	// need a distinguishing way to denote zero from no mapping case 
        if (value == 0 )
            arr[key] = -1;
        else
            arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (arr[key] == -1)
            return 0;
        else if (arr[key] == 0)
            return -1;
        else
            return arr[key];
            }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
