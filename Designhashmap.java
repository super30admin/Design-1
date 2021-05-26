
// Time Complexity : O(1) :constant for all operations: put, get, remove
// Space Complexity : O(n) Since we are storing n elements. 
// Did this code successfully run on Leetcode :yes, use the class name they have if testing
// Any problem you faced while coding this : it has two approaches. i am doing the array one because its easier but the sad part is that this one overrides 
// the values when collision happens but it is still a valid hash table. it needs work for collision handling which is why i will work on the double hashing and chaining concepts later  
//I am wrapping my head around the linked list one will take me some time to work out the bugs in that one. Ill do linear/quadratic probing later here for the array one.
// Your code here along with comments explaining your approach

public class Designhashmap {

	/* Part 1: array approach : completed. Part 2: nodes DS approach: pending
	 * 
	 * MyHashMap() initializes the object with an empty map.
		void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
		int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
		void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
		
	 * Algorithm: 
	 *1. Create a DS like array to hold values based on keys
	 *2. create a hash function that generates unique values for each key. 
	 *			Hash Function :When Our key is a +ve integer.  Take a key %1000 = uniqueValue.  
	 *3. store the values in the hash table array DS in a put method. hasharray[uniqueValue] = value.
	 *4. retrieve those values using the same hash function in a get method
	 *
	 * */
	
	static int hasharray[];  
	
	 public static void Designhashmap() {
		 
		 hasharray = new int[10];
		 for (int i : hasharray) {
			 hasharray[i] = 0; 
			 System.out.print(hasharray[i]);
		 }    
	    }
	 
	 
	 
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//	    public int get(int key) {
//	        
//	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        
	    }
	   
	    public static void main(String []args) {
	    	Designhashmap();
	    }

	    
	   	    
	    
	}
	
	











