// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  im not very familiar with hashing, I watched some youtube videos to get idea  with hashing

import java.util.*;
class MyHashSet {

    // intialize the size of the array here I am taking 100 as a size of the parent
    private final int arraysize = 100;

    // array of list to store list in array
    private List<Integer>[] parentList;

    // intialize data structure
    public MyHashSet() {

        // intialize the parentlist with arraysize
        parentList = new LinkedList[arraysize];

        // intially all the list in array should be null
        for (int i = 0; i < arraysize; i++) {
            parentList[i] = null;
        }
    }

    public void add(int key) {

        // Using modulo for hashing
        int index = key % arraysize;

        // get childList from index where we are going to store the element
        List<Integer> childList = parentList[index];

        if (childList == null) {

            // declare list foor index
            List<Integer> list = new LinkedList<>();

            // add the value of key in list
            list.add(key);

            // update parentList of the index after adding element into list
            parentList[index] = list;
        } else {

            // else check if element is already in the list or not because it is a hashSet
            if (!childList.contains(key)) {

                // after checking it add element into the childList
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        // to get index of the element that are present in the arrayList
        int index = key % arraysize;

        // get childList where our element is available
        List<Integer> childList = parentList[index];
        if (childList != null) {

            // we remove element from the childList
            childList.remove(Integer.valueOf(key));
        }

    }

    public boolean contains(int key) {
        // to get index of the element that are present in the arrayList
        int index = key % arraysize;

        // get childList where our element may be available
        List<Integer> childList = parentList[index];

        // return true if element is available or return false
        return childList != null && childList.contains(key);
    }

    public static void main(String[] args) {

        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(101);
        System.out.println(hashSet.parentList[1]);
        System.out.println("set contains 1?" + hashSet.contains(1));
        hashSet.remove(1);
        hashSet.remove(1);
        System.out.println("set contains 1?" + hashSet.contains(1));

    }
} 