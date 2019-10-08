// Idea : We need to have the one booolean array and actual map array.
// By default boolean array will be false.
// 1. store the value at given index and make the corresponding index value in boolean as true.
// 2. Assumption is that we have the map of size 1000001;
// 3. By put method call, we have the boolean value as associated key to true, and place the value at the given key in actual map array.
// 4. get -- > return the boolean[key]
// 5. remove --> make the boolean[key] to false;

package org.dailypractise;



public class D1_DesginHM {

	public static void main(String[] args) {
		myHashMap lm = new myHashMap();
		lm.put(1, 1);
		lm.put(2, 2);
		lm.put(3, 3);
		lm.put(4, 4);
		System.out.println("This Value should be 1  : \t"+lm.get(1));
		lm.remove(1);
		System.out.println("This Value should be -1 : \t"+lm.get(1));


	}
	

}

class myHashMap{
	boolean b[] = null;
	int map[] = null;
	
	/** Initialize your data structure here. */
    public myHashMap() {
       b   = new boolean[1000001];
       map = new int[1000001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        b[key] = true;
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	if(b[key]) return map[key];
		
    	return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        b[key] = false;
    }
	
}
