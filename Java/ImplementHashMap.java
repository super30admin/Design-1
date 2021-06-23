// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 Using Large Sized Array
 Arrays initialize default value as 0, so using Arrays.fill(arr, -1) --> as the requirement is to get -1 if there is no mapping for the key
*/


class MyHashMap {

 int arr[];
 /** Initialize your data structure here. */
 public MyHashMap() {
  arr = new int[1000001];
  Arrays.fill(arr, -1);
 }

 /** value will always be non-negative. */
 public void put(int key, int value) {
  arr[key] = value;
 }

 /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
 public int get(int key) {
  return arr[key];
 }

 /** Removes the mapping of the specified value key if this map contains a mapping for the key */
 public void remove(int key) {
  arr[key] = -1;
 }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */