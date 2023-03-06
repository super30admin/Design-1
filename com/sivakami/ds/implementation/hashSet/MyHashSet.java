/*		Time complexity - O(log N/K)
		Space Complexity - O(K + N)	
		Approach - Implemented hash set using array of bst. 
				   add - Data is added to the bst tree in the offset represented by hashfxn. 
				   		 time complexity of adding in a BST is O(log D) 
				   		 	Where D is the depth of the tree. 
				   		 	If the tree is skewed then Depth D becomes N no of nodes in tree.
				   		    Here D is N / k (assuming that the values are all equally distributed), Where 
				   		    					N is the number of values in hashmap. 
				   		       					k is the key size of the hashmap. 
				   remove - Data is removed from BST tree in the offset represented by hashfx.
				   			O(N/k) time.
*/
package com.sivakami.ds.implementation.hashSet;

public class MyHashSet {
	  private Bucket[] bucketArray;
	  private int keyRange;

	  public MyHashSet() {
	    this.keyRange = 769;
	    this.bucketArray = new Bucket[this.keyRange];
	    for (int i = 0; i < this.keyRange; ++i)
	      this.bucketArray[i] = new Bucket();
	  }

	  protected int _hash(int key) {
	    return (key % this.keyRange);
	  }

	  public void add(int key) {
	    int bucketIndex = this._hash(key);
	    this.bucketArray[bucketIndex].insert(key);
	  }

	  public void remove(int key) {
	    int bucketIndex = this._hash(key);
	    this.bucketArray[bucketIndex].delete(key);
	  }

	  /** Returns true if this set contains the specified element */
	  public boolean contains(int key) {
	    int bucketIndex = this._hash(key);
	    boolean res = this.bucketArray[bucketIndex].exists(key);
	    System.out.println(res);
	    return res;
	  }
	}
