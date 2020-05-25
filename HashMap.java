 import java.util.List;

import sun.net.www.content.text.plain;

import java.util.LinkedList;
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Collision Control

// Your code here along with comments explaining your approach
public class HashMap {
    List<Integer> listKey;
    List<Integer> listValue;


    //constructor
    public HashMap(){
        listKey = new LinkedList<Integer>();
        listValue = new LinkedList<Integer>();
    }

    //Here we check if the key is already present and if yes then we replace the value of that key with the new input value. Else add the new key and its value to the linked list
    public void insert(int key, int value){
        if(listKey.contains(key)){
            listValue.set(listKey.indexOf(key), value);
        }
        else{
            listKey.add(key);
            listValue.add(value);
        }
    }

    //if key is present returns the stored value for that key else returns -1
    public int get(int key){
        if(listKey.contains(key)){
            return listValue.get(listKey.indexOf(key));
        }
        else{
            return -1;
        }
    }

    //if the specified key is present we remove the key value from listValue and the key itself stored in listKey
    public void remove(int key){
        if(listKey.contains(key)){
            listValue.remove(listKey.indexOf(key));
            listKey.remove(Integer.valueOf(key));
        }
    }

}