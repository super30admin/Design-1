import java.util.*;
import java.lang.*;
import java.io.*;

class MyHashMap {

    int hashMapArr[];
    public MyHashMap() {
    	hashMapArr=new int[1000];
    	fill(hashMapArr,-1);//Fill the entire array with -1
        
    }
    void fill(int arr[], int value)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		arr[i]=value;
    	}
    }
  
    public void put(int key, int value) {
    	hashMapArr[key]=value;
        
    }
    
    public int get(int key) {
    	return hashMapArr[key];
        
    }
    
    public void remove(int key) {
    	hashMapArr[key]=-1;
        
    }

    public static void main (String[] args) throws java.lang.Exception
	{
		MyHashMap map=new MyHashMap();
		map.put(1,2);
		map.put(2,3);
		System.out.println("Value for key"+map.get(1));
		System.out.println("Value for key"+map.get(3));
		map.put(2,4);
	    System.out.println("Value for key"+map.get(2));
	    map.remove(2);
	    System.out.println("Value for key"+map.get(2));

	}
}
