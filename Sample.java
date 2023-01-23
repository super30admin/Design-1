// Time Complexity : O(N) - contains logic require atmost N iterations to check if the element is present.
// Space Complexity : O(N) - though array size is fixed, the list in each array grows with the number of elements (N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.Iterator;
import java.util.LinkedList;
// A simple approach without using any hash function. 
// I am just using an arraylist to store the elements and everytime
// I am checking if it is present in the list before adding or removing it.
// To check if the element is present, I am using indexOf method. 
// It worked on LeetCode.
// TC: O(N) for all methods.
/*class MyHashSet { 
    ArrayList<Integer> set;
    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        set.add(key);
    }
    
    public void remove(int key) {
        if(contains(key)) {
            int idx = set.indexOf(key);
            set.remove(idx);
        }
    }
    
    public boolean contains(int key) {
        return set.indexOf(key) != -1;
    }
}*/


/**
 * @author akhilreddy619
 * In this class, I am using an array of linkedlist.
 * _hash: (extra function added) to calculate the index in which the element has 
 * to be inserted/removed.
 * For Add: calculating the hash and check if it has a list in that index. If so,
 * check if the key is already inserted, if not insert it else skip it. If the list
 * is not initialized, then initialize it and insert the key. Then put that list in 
 * the array.
 * For Remove:Calcuate the hash and check if it has a list in that index. If so, 
 * iterate that list and remove the element else skip it.
 * For Contains: Calculate the hash and check if it has a list in that index. If not,
 * return false, else check if that list has this key and return boolean accordingly.
 *
 */
class MyHashSet {
    LinkedList<Integer>[] set;
    public MyHashSet() {
        set = new LinkedList[15];
    }
    
    public void add(int key) {
        int hash = _hash(key);
        LinkedList<Integer> keySet = set[hash];
        if(keySet == null) {
            keySet = new LinkedList<>();
            keySet.add(key);
            set[hash] = keySet;
        } else {
            if(!keySet.contains(key))
                keySet.add(key);
        }
    }
    
    public void remove(int key) {
        int hash = _hash(key);
        LinkedList<Integer> keySet = set[hash];
        if(keySet != null) {
            Iterator it = keySet.iterator();
            while(it.hasNext()) {
                if(key == (int) it.next()) {
                    it.remove();
                    break;
                }
            }
        }
    }
    
    public boolean contains(int key) {
        int hash = _hash(key);
        LinkedList<Integer> keySet = set[hash];
        if(keySet != null && keySet.contains(key))
            return true;
        return false;
    }

    public int _hash(int key) {
        return key % set.length;
    }
}