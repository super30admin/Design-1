/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class MyHashMap {

    /** Initialize your data structure here. */
    int[] a;
    public MyHashMap() {
        a = new int[1000001];
        Arrays.fill(a,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        a[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return a[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        a[key]=-1;
    }
    
    public static void main(String args[]) 
    { 
        MyHashMap ob = new MyHashMap(); 
        ob.put(0, 234);
        ob.put(10, 345);
        ob.put(3, 785);
        ob.put(7, 127);
        System.out.println("Value for key 3 is : "+ob.get(3)); 
        ob.remove(10);
        System.out.println("Value for key 10 is : "+ob.get(10));  
    } 
}


// Time complexity : O(1) for put, get, remove
// Space complexity : O(n)