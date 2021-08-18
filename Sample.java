// Time Complexity : O(1) for hashmap question and O(1) for hashset
// Space Complexity : O(n) for hashmap question and O(n) for hashset
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : I was trying to implement


// Your code here along with comments explaining your approach



import java.util.*;

class MyHashMap {

    /** Initialize your data structure here. */
    public MyHashMap() {

    }
    ArrayList<List<Integer>> hashList = new ArrayList<List<Integer>>(10000000);
    Set<Integer> hashSet = new HashSet<Integer>(1000000);
    ArrayList<Integer> keyList = new ArrayList<>(10000000);


    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (hashSet.contains(key) ){

            int length = hashSet.size();
            int pos =keyList.indexOf(key);
            System.out.println(pos);
            hashList.get(pos).set(1,value);

        }
        else{
            hashSet.add(key);
            List<Integer> templist=Arrays.asList(key,value);
            hashList.add(templist);
            keyList.add(key);

        }
    }


    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {


        if (hashSet.contains(key) ){
            int length = hashList.size();
            int pos =keyList.indexOf(key);
            System.out.println(pos);
            return hashList.get(pos).get(1);


        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        if (hashSet.contains(key) ){
            int pos =keyList.indexOf(key);

            hashList.remove(pos);
            hashSet.remove(key);
            keyList.remove(pos);
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


import java.util.*;
import java.lang.Math;

class MinStack {
    ArrayList<Integer> arr;
    ArrayList<Integer> minimumArray;

    int minimumVal =  (int)(Math.pow(-2,31));
    Integer maximumVal = (int)Math.pow(2,31)-1;
    int min = maximumVal+1;

    /** initialize your data structure here. */
    public MinStack() {
        arr = new ArrayList<Integer>();
        minimumArray = new ArrayList<Integer>();

    }

    public void push(int val) {
        arr.add(val);
        if (val <= min){
            minimumArray.add(min);
            min = val;

        }
        minimumArray.add(val);


    }

    public void pop() {
        if(minimumArray.get(minimumArray.size()-1) == min){

            min = minimumArray.get(minimumArray.size()-2);
            // minimumArray.remove(minimumArray.size()-1);
        }
        arr.remove(arr.size()-1);

    }

    public int top() {
        return arr.get(arr.size() -1);

    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */