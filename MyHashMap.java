// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {

    /** Initialize your data structure here. */
  	//Using arrays to implement HashMap
    int[] hashMap = new int[1000001];
    public MyHashMap() {
    	//As we have to return -1 if the map contains no mapping for a particular key, initializing all values to -1. 
        for(int i=0;i<hashMap.length;i++){
            hashMap[i] = -1;
        }

    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	//Map the passed key to the passed value
        hashMap[key] = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	// return the value mapped to the passed key. returns -1 if not mapped.
        return hashMap[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// Driver code 
class Main { 
    public static void main(String args[]) 
    { 
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);          					// update the existing value
		System.out.println(hashMap.get(2));            // returns 1 
		hashMap.remove(2);          					// remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found) 
    } 
}