// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Created a list of list to store the value. 

import java.util.*;

class MyHashSet {
    List<List<Integer>> list;
    int ARRAY_SIZE;
    public MyHashSet() {
        ARRAY_SIZE = 100;
        list = new ArrayList<>(ARRAY_SIZE);
        for (int i=0;i<ARRAY_SIZE;i++){
            list.add(null);
        }
    }

    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> tmp = list.get(index);
        if (tmp != null) {
            if (!tmp.contains(key)) {
                tmp.add(key);
            }
        } else {
            List<Integer> tmp1 = new java.util.LinkedList<>();
            tmp1.add(key);
            list.set(index, tmp1);
        }
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> tmp = list.get(index);
        if (tmp != null) {
            tmp.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> tmp = list.get(index);
        if (tmp != null) {
            return tmp.contains(key);
        }
    return false;
    }

    public static void main(String[] args){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)

    }
    
}