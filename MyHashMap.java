
import java.util.Arrays;

public class MyHashMap {
	
	int[] map=new int[1000000];
	

    /** Initialize your data structure here. */
    public MyHashMap() {
    	Arrays.fill(map,Integer.MIN_VALUE);  	
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	map[key]=value;
    }
    
   

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	if(map[key] ==Integer.MIN_VALUE)
            return -1;
    	return map[key];	
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	
    	if(map[key]!=Integer.MIN_VALUE)
            map[key]=Integer.MIN_VALUE;
    }
    
    public static void main(String args[]) {
    	MyHashMap obj = new MyHashMap();
    	obj.put(117,66);
    	int param_2 = obj.get(117);
    	System.out.println(param_2);
    	obj.remove(117);
    	
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


