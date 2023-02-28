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
