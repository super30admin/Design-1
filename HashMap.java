//Exercise_1 : Design Hashmap
// Time Complexity : O(N)  -> for all operations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

//Note: I used ArrayList Data Structure of type int array where I'm storing key in first index and the value in second index.

/**** Steps ****/
/*
1) Created a global array list object of type int array, so that key can be stored in first index and value can be stored in second index
2) Put :  --> O(n)
      a) Initialize a boolean variable 'keyFound' with false to check whether key exists in the list or not. 
      b) If key exists then update the value and exit.
      c) If key doesn't exits then insert the key and value in the array list.
3) Get : --> O(n)
      - Traverse the whole list and check whether key exists or not. If key exists return the value otherwise return -1
4) Remove:  --> O(n)
      - Traverse the whole list and check whether key exists or not. If key exists return remove the element from the list and exit.          
*/

import java.util.*;

class MyHashMap {
     
    private List<int[]> list;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //O(n)
        boolean keyFound = false;
        
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0]==key){
                list.get(i)[1] = value;
                keyFound = true;
                break;
            }
        }
        
        if(!keyFound){
            list.add(new int[]{key,value});
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //O(n)
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0]==key){
                return list.get(i)[1]; 
            }
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //O(n)
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0]==key){
                list.remove(i);
                break;
            }
        }
    }
}