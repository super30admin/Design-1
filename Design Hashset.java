// Time Complexity :O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
class MyHashSet {
    private int MAX_VALUE = 1000000;
    private int Arr_Size = 100;
    List<List<Integer>> parentList; //Creating an Arraylist of List

    ///Initializing the Arraylist to null
    public MyHashSet() {
       parentList = new ArrayList<>(Arr_Size);
       for (int i=0; i<Arr_Size; i++)
       {
           parentList.add(null);
       }
        
    }
    
    public void add(int key) {
        int index = key % Arr_Size; //Generating the index at which the element will be added
        List<Integer> childList = parentList.get(index);//Accessing the list from the arraylist
        if (childList == null)
        {
            List<Integer> list = new LinkedList<Integer>();//Initializing the new list for the bucket if it is null
            list.add(key);
            parentList.set(index, list);//Setting the list to the bucket at the index generated
            
        }
        else
        {
            if (!childList.contains(key))//if the lost already exists, just appending the key at the existing list
            {
                childList.add(key);
            }
        }
        
    }
    
    public void remove(int key) {
        int index = key % Arr_Size;
        List<Integer> childList = parentList.get(index);
        if (childList != null)
        {
            childList.remove(Integer.valueOf(key));//Removes the key 
        }


    }
    
    public boolean contains(int key) {
        int index = key % Arr_Size;
        List<Integer> childList = parentList.get(index);
        //if (childList != null)
        {
            return childList != null && childList.contains(key);//Checks if the key exists and return the boolean value
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
