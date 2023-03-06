package com.sivakami.ds.implementation.hashMap;

public class Pair<U, V> {
	  private U first;
	  private V second;

	  public Pair(U first, V second) {
	    this.first = first;
	    this.second = second;
	  }
	  
	  public V getValue() {
		  return this.second;
	  }
	  
	  public U getKey() {
		  return this.first;
	  }
	  
	  protected void setValue(V second) {
		  this.second = second;
	  }
	  
	}
