// Time Complexity : hashcode- O(1), put , get and  remove- O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// First approcach using Array of Lists of int arrays of size 2 to hold key value pairs

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashMap {
    List<int[]>[] hashmapKeys ;
    int size;
    int currentFilled;

    /** Instantiate data structure here as an
     * Array of Lists of Key,Value pairs in an array of size 2**/
    public MyHashMap(){
        size=100;
        hashmapKeys = new ArrayList[100];
        currentFilled=0;
    }

    /** Generate hashcode for a key here **/
    public int hashcode(Object key){
        return key.hashCode()%size;
    }

    /** In the put method we first see if the size of
     *  array has reached 80% capacity and needs to be increased
     *  We then go through the hashmap to see if the key is already present
     *  If present we replace value in the [2] position of key,value array **/
    public void put(int key, int value) {
        if((float)currentFilled/size>0.80){
            growAndrefill();
        }
        int index = this.hashcode(key);
        boolean found=false;
//        if there is no list at the hashcode index
        if(hashmapKeys[index]==null){
            hashmapKeys[index] = new ArrayList<>();
            hashmapKeys[index].add(new int[]{key,value});
        }else {
            for (int i = 0; i < hashmapKeys[index].size(); i++) {
                if (hashmapKeys[index].get(i)[0] == key) {
                    hashmapKeys[index].get(i)[1] = value;
                    found = true;
                    break;
                }
            }
            // if key not found after searching the list, add to the end of the list.
            if (found == false) {
                int[] tempKVPair = new int[2];
                tempKVPair[0] = key;
                tempKVPair[1] = value;
                hashmapKeys[index].add(tempKVPair);
            }
        }
    }

    /** In the get method, we first see if the hashed index is empty then we return -1 directly
     * Else we search the list for key, return value at position [2] of key-value array if found,
     * else return -1 **/
    public int get(int key) {
        int index = this.hashcode(key);
        if(hashmapKeys[index]==null){
            return -1;
        }else {
            for (int i = 0; i < hashmapKeys[index].size(); i++) {
                if (hashmapKeys[index].get(i)[0]==key){
                    return hashmapKeys[index].get(i)[1];
                }
            }
            return -1;
        }

    }

    /** In the remove method, we first see if the hashed index is empty then we return directly
     * Else we search the list for key, and if found, remove it from the list, else return **/
    public void remove(int key) {
        int index = this.hashcode(key);
        if(hashmapKeys[index]==null) {
            return;
        }else{
            List<int[]> temp = hashmapKeys[index];
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i)[0]==key){
                    temp.remove(i);
                    return;
                }
            }

        }
    }

    /** We use this method to double the size of the array if its capacity has reached 80%
     * First we add current values to a temp array , double the size of original array ,
     * Fill in new array with empty lists, then add all old values to the new array. **/
    public void growAndrefill(){
        size=size*2;
        currentFilled=0;
        List<int[]>[] tempKeys = hashmapKeys;
        hashmapKeys = new ArrayList[size];
        List<int[]> filler = new ArrayList<>();
        Arrays.fill(hashmapKeys,filler);
        for(int i=0;i<tempKeys.length;i++){
            if(tempKeys[i].size()!=0){
                for(int j=0;j<tempKeys[i].size();j++) {
                    hashmapKeys[i].add(tempKeys[i].get(j));
                }
            }
        }
    }



}
