import java.util.ArrayList;
import java.util.LinkedList;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class HashMapImpl{
	ArrayList<ArrayList>baseList;
	ArrayList <Integer> innerList;
	
	final int INITIAL_CAPACITY=25;
	
    /** Initialize your data structure here. */
    public HashMapImpl() {
    	
    	baseList=new ArrayList<ArrayList>(INITIAL_CAPACITY);
    	
 
    	//innerList = new ArrayList<Integer>(INITIAL_CAPACITY);
    	
    	// initialize baseList --needed to allow arbitary key inserts into hashmap
    	for (int i=0;i< INITIAL_CAPACITY; i++)
		{
			baseList.add(i,null);
			
		}
    	
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	
    	
    	if (!baseList.contains(Integer.valueOf(value))) {
    		
    		innerList = new ArrayList<Integer>(INITIAL_CAPACITY);
    		innerList.add(0,value);
    		
    	}
    	else {
    		innerList.add(0,value);
    		
    	}
    	
    	baseList.add(key, innerList);
    	
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	
    	// as per initialization in constructor
    	if (baseList.get(key) == null) {
    		System.out.println("reached a non-existent key");
    		return -1;
    	}
    	else {
    		
    		return (int)baseList.get(key).get(0);
    	}
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	
    	baseList.remove(key);
    	baseList.add(key, null);
        
    }
    
    public static void main(String [] args) 
    {
    	HashMapImpl obj = new HashMapImpl();
    	
    	//Test case from LeetCode
    	obj.put(1,1);
    	obj.put(2,2);
    	obj.get(1);
    	obj.get(3);
    	obj.put(2,1);
    	obj.get(2);
        obj.remove(2);
        
    	System.out.println("Element is: " + obj.get(2));	
    	
    }
}


