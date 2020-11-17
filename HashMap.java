// Time Complexity : O(1), O(n) to initialize
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried implementing it with linked list but found array to be easier with little difference in runtime



public class HashMap {

	//use an array since we are able to get an element in O(1) runtime
	int[] entries;
	/** Initialize your data structure here. */
	 /** Initialize your data structure here. */
	//O(n) runtime to initialize HashMap
    public HashMap() {
    	//Since there is only 0 to 1000000 elements, no need for resize method
        entries = new int[1000001];
        
        //since we are dealing with integers, index can be used as key
        for(int i = 0; i < entries.length; i++) {
        	entries[i] = -1;
        }
    }
    
    //O(1) run time since using array
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	//get location of key-value pair
    	
    	entries[key] = value;    
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

    	int target = entries[key];
        return target;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	
    	entries[key] = -1;
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
	}

}
