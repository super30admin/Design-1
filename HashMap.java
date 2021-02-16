// Time Complexity : O(n) for filling arr with -1 initially
// Space Complexity : O(n), for arr 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
class MyHashMap {

    /** Initialize your data structure here. */
    int[] arr;
    public MyHashMap() {
        arr = new int[1000000]; //SC: O(n)
	//TC: O(n)
        Arrays.fill(arr,-1);
    }
    
    /** value will always be non-negative. */ 
    //TC: O(1)
    public void put(int key, int value) {
         arr[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    //TC: O(1)
    public int get(int key) {
        return arr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    //TC: O(1)
    public void remove(int key) {
        arr[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */