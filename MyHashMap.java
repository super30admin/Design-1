// Time Complexity : 0(5) --> O(1)
// Space Complexity : O(5) --> O(1) 
// Note here I am not considering size of List<MyMap> my_hashtable
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : trying to fin value of max_keys was difficult
// issues : Memory exceeded/ out of bound exception

import java.util.ArrayList;
import java.util.List;


public class MyHashMap {
	
	private int max_keys;
	private List<MyMap> my_hashtable;
	/** Initialize your data structure here. */
    public MyHashMap() {
        max_keys = 99999;
        my_hashtable  = new ArrayList<MyMap>();
        for(int i = 0; i < max_keys; i++) {
        	my_hashtable.add(new MyMap());
        }
    }
    
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int hashKey = getHashKey(key);
    	MyMap m = my_hashtable.get(hashKey);
    	int a = m.getValue(hashKey);
    	return this.my_hashtable.get(hashKey).getValue(hashKey);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = getHashKey(key);
        this.my_hashtable.get(hashKey).update(hashKey, value);      
    }
    
    private int getHashKey(int key) {
    	return key % 99999;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	this.my_hashtable.get(key).remove(key);
    }
    
	
	public static void main(String args[]) 
    { 
		MyHashMap obj = new MyHashMap();
		
		
		
		obj.put(1,1);
		obj.put(2,2);
		
		int a = obj.get(1);
		System.out.println(a);
		System.out.println(obj.get(3));
		obj.remove(2); 
    }
	
	
	//needed ds
	public class MyMap{
		private int size;
		private List<Pair<Integer, Integer>> myList;
		
		public MyMap() {
			int size = 5;
			myList = new ArrayList<Pair<Integer, Integer>>(size);
			for(int i = 0; i < size; i++) {
				myList.add(new Pair(-1, -1));
			}
		}
		
		public void update(int key, int value) {
			boolean flag = false;
			int newKey = newKey(key);
			for(int i = 0; i < 5; i++) {
				if(myList.get(i).getKey() == newKey) {
					flag = true;
					myList.get(i).setValue(value);
					break;
				}
			}
			if(!flag) {
				myList.set(newKey, new Pair(newKey, value));
			}
		}
		
		public void remove(int key) {
			int newKey = newKey(key);
			for(int i = 0; i < 5; i++) {
				if(myList.get(i).getKey() == newKey) {
					myList.get(i).setValue(-1);
					break;
				}
			}
		}
		
		public int getValue(int key) {
			int newKey = newKey(key);
			for(int i = 0; i < 5; i++) {
				if(myList.get(i).getKey() == newKey) {
					return myList.get(i).getValue();
				}
			}
			return -1;
		}
		
		public int newKey(int key) {
			return key % 5;
		}
		
		public class Pair <T, U>{
			private T key;
			private U value;
			
			public Pair(T key, U value) {
				this.key = key;
				this.value = value;
			}
			public T getKey() {return this.key;}
			public U getValue() { return this.value;}
			public void setValue(U val) { this.value = val;}
		}
	}

}
