
// Time Complexity : add, remove and contains operations have worst case time complexity of O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;

public class MyHashSet {

    // Using the ArrayList data structure to implement HashSet behind the hood
    ArrayList<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }


    /*
        Using the contains method of arraylist to check for duplicates
     */
    public void add(int key) {
        if(!list.contains(key))
        {
            list.add(key);
        }
    }

    /*
        Using the remove method of arraylist to remove element from MyHashSet
     */
    public void remove(int key) {
        list.remove(Integer.valueOf(key));
    }

    /*
        Using the contains method of arraylist to check whether MyHashSet contains the key or not
     */
    public boolean contains(int key) {
        return list.contains(key);
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */