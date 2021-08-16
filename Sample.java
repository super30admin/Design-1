// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I encountered a lot of runtime errors but each time
// I run the code, it shows accepted but when I submit it, I get a runtime error.


// Your code here along with comments explaining your approach

class MyHashMap {

    /** Initialize your data structure here. */
    int [] hashMap = null;
    
    public MyHashMap() {
        hashMap = new int[1000001]; //Initialize a new integer array to the size given
        Arrays.fill(hashMap, -1); //updates the array to -1
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMap[key] = value; //Updates the map at that particular index to the value
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMap[key]; //returns the map at that particular index
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        put(key, -1); //passes -1 to the key because we don't need to return
                    // any value to a void function.
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

 //NB: key is the same as the index
 