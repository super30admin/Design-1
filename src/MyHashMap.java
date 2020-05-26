import java.util.Arrays;

// Time Complexity : initialization of hashmap - O(n), all other operations O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashMap {
	final static int MAX = 1000000;
	
	int[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.data = new int[MAX];
        Arrays.fill(this.data, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int loc = key % MAX;
        data[loc] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int loc = key % MAX;
        return this.data[loc];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    		int loc = key % MAX;
    		
        if(this.data[loc] != -1)
    			this.data[loc] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */