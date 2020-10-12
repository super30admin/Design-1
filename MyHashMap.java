// Time Complexity : O(n)
// Space Complexity : O(n) (Auxiliary Space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : This code is not memory efficient. I couldn't optimize it.

import java.util.List;
import java.util.ArrayList;

public class MyHashMap {

	class innerClass
	{
		int key, value;
		
		public void insertHashData(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
		
	}
	
	private innerClass ins;
	private List<innerClass> hashStore;
	
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.hashStore = new ArrayList<innerClass>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	this.ins = new innerClass();
    	ins.insertHashData(key, value);
    	
    	for(int i = 0; i < hashStore.size(); i++)
    	{
    		innerClass putInsObj = hashStore.get(i);
    		if(putInsObj.key == key)
    		{
    			hashStore.remove(i);
    			break;
    		}
    	}
    	hashStore.add(ins);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
    	for(int j = 0; j < hashStore.size(); j++)
    	{
    		innerClass getInsObj = hashStore.get(j);
    		if(getInsObj.key == key)
    			return getInsObj.value;
    	}
    	return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(int k = 0; k < hashStore.size(); k++) 
        {
        	innerClass remInsObj = hashStore.get(k);
        	if(remInsObj.key == key)
        	{
        		hashStore.remove(k);
        		break;
        	}
        }
    }

    public static void main(String[] args)
    {
    	MyHashMap hashMap = new MyHashMap();
    	hashMap.put(1, 1);
    	hashMap.put(2, 2);
    	System.out.println(hashMap.get(1));
    	
    	System.out.println(hashMap.get(3));
    	            // returns -1 (not found)
    	hashMap.put(2, 1);          // update the existing value
    	System.out.println(hashMap.get(2));
    	           // returns 1 
    	hashMap.remove(2);          // remove the mapping for 2
    	System.out.println(hashMap.get(2));
    	            // returns -1 (not found) 
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
    }
}