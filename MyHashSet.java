
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// first thought of using with arrays because the size is fixed but it will waste a huge amount
//space so came up with this solution;

// Your code here along with comments explaining your approach
// here in this code im using a arraylist of linkedlist of Integers which will store value according to the index.

import java.util.*;
public class MyHashSet{
    
    private final int MAX_SIZE=100;
    List<List<Integer>> parentList;
    //Initialising the constructor 
    public MyHashSet() {
        parentList=new ArrayList<>(MAX_SIZE);
        for(int i=0;i<MAX_SIZE;i++){
            parentList.add(null);// initialising the array list with null values.
        }
    }
    
    public void add(int key) {
        int index=key%MAX_SIZE;//calculating the index to store the val;
        List<Integer> childList=parentList.get(index);
        if(childList==null){
                List<Integer> llist=new LinkedList<Integer>();
                llist.add(key);
                parentList.set(index,llist);
        }
        else{
            if(!childList.contains(key)){// if the hashset does contains key then only the key gets added.
                childList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index=key%MAX_SIZE;
        List<Integer> childList=parentList.get(index);
        
        if(childList!=null){
                childList.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index=key%MAX_SIZE;
        List<Integer> childList=parentList.get(index);
        return childList!=null && childList.contains(key);
        
    }
    public static void main(String args[]){
        MyHashSet obj=new MyHashSet();
        obj.add(10);
        obj.add(20);
        obj.add(1000);
        obj.add(232);
        obj.remove(10);
        obj.remove(100);
        System.out.println(obj.contains(232));
        System.out.println(obj.contains(99));
    }
}