  
// Time Complexity : O(N/K)   K-> number of buckets (2069) , N -> number of keys
// Space Complexity : O(k + M) M-> number of keys ,  K -> number of buckets (2069)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Pair<U,V>{
	
	public U first;
	public V second;
	
	public Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}
}

class Bucket{
	List<Pair<Integer, Integer>> bucket;
	
	public Bucket() {
		this.bucket = new LinkedList<Pair<Integer, Integer>>();
	}
	
	
	public Integer get(Integer key) {
		for(Pair<Integer, Integer> pair: this.bucket) {
			if(pair.first.equals(key)) {
				return pair.second;
			}
		}
		return -1;
	}
	
    public void update(Integer key, Integer value) {
    	boolean found = false;
    	for(Pair<Integer, Integer> pair: this.bucket) {
			if(pair.first.equals(key)) {
				pair.second = value;
				found = true;
			}
		}	
    	
    	if(!found) {
    		this.bucket.add(new Pair<Integer, Integer>(key,value));
    	}
	}
    
    public void remove(Integer key) {
    	for(Pair<Integer, Integer> pair: this.bucket) {
			if(pair.first.equals(key)) {
				this.bucket.remove(pair);
			}		
    	}
	}   
	
}

public class HashMap{
	
	/** Initialize your data structure here. */
	ArrayList<Bucket> hashtable;
	int keyspace;
	public HashMap() {
		this.keyspace = 2069;
		this.hashtable = new ArrayList<Bucket>();	
		for(int i=0;i< this.keyspace;i++) {
			this.hashtable.add(new Bucket());
		}
	}
	
	 /** value will always be non-negative. */
	public void put(int key, int value) {
		int hashkey = key % this.keyspace;
		this.hashtable.get(hashkey).update(key, value);			
	}
	
	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */	
	public int get(int key) {
		int hashkey = key % this.keyspace;
		return this.hashtable.get(hashkey).get(key);		
	}
	
	 /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int hashkey = key % this.keyspace;
		this.hashtable.get(hashkey).remove(key);	
	}
	
	public static void main(String[] args) {
		HashMap obj = new HashMap();
		
		obj.put(1, 1);
		obj.put(2, 2);
	    System.out.println("get(1): " +obj.get(1));		
		System.out.println("get(3): " +obj.get(3));
		obj.put(2,3);		
		System.out.println("get(2): " +obj.get(2));
		obj.remove(2);
		System.out.println("get(2): " +obj.get(2));
				
	}
}