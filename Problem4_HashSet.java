
import java.util.*;
import java.lang.*;
import java.io.*;

class MyHashSet {
	boolean arr[];

    public MyHashSet() {
    	arr=new boolean[1000];
        
    }
    
    public void add(int key) {
    	if(key<arr.length-1)
    	{
    	  arr[key]=true;
    	}
        
    }
    
    public void remove(int key) {
    	arr[key]=false;
        
    }
    
    public boolean contains(int key) {
    	return arr[key];
        
    }
    public static void main (String[] args) throws java.lang.Exception
	{
		MyHashSet set=new MyHashSet();
		set.add(1);
		set.add(2);
		System.out.println(set.contains(1));
		set.remove(1);
		System.out.println(set.contains(1));
	}
}

