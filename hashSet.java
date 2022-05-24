// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  Yes, I haven't understand how to use hashing so, I have watched some youtube videos to get familiar with hashing

import java.util.*;

class MyHashSet {

    // intialize the size of the array here I am taking 100 as a size of the parent
    // array
    private final int ARRAY_SIZE = 100;

    // I am declaring the array of list to store list in array
    private List<Integer>[] parentList;

    // intialize the data structure
    public MyHashSet() {

        // intialize the parentlist with arraysize
        parentList = new LinkedList[ARRAY_SIZE];

        // intially all the list in array should be null
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList[i] = null;
        }
    }

    public void add(int key) {

        // I am here using modulo for hashing
        int index = key % ARRAY_SIZE;

        // get childList from index where we are going to store the element
        List<Integer> childList = parentList[index];

        // if childList is null that means there is no elements in that list
        if (childList == null) {

            // declare list for that index
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
        int index = key % ARRAY_SIZE;

        // get childList where our element is available
        List<Integer> childList = parentList[index];
        // here we check childLIst is not null if there is null than there is no element
        // in the list
        if (childList != null) {

            // here we remove element from the childList
            childList.remove(Integer.valueOf(key));
        }

    }

    public boolean contains(int key) {
        // to get index of the element that are present in the arrayList
        int index = key % ARRAY_SIZE;

        // get childList where our element may be available
        List<Integer> childList = parentList[index];

        // return true if element is available or return false
        return childList != null && childList.contains(key);
    }

    public static void main(String[] args) {

        // object 0f MyHashSet
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(7);
        hashSet.add(8);
        hashSet.add(101);

        System.out.println(hashSet.parentList[1]);
        System.out.println("set contains 1?" + hashSet.contains(1));
        hashSet.remove(1);
        hashSet.remove(1);
        System.out.println("set contains 1?" + hashSet.contains(1));

    }
}