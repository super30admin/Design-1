// Problem 1:
// Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I know that this can be more optimized using the linked list. Learning more on linked list.


// Your code here along with comments explaining your approach
class MyHashMap {

    List<Integer> list_of_key;
     List<Integer> list_of_value;
 
     /** Initialize your data structure here. */
     public MyHashMap() {
         list_of_key = new ArrayList<Integer>();
         list_of_value = new ArrayList<Integer>();
     }
 
     /** value will always be non-negative. */
     public void put(int key, int value) {
         if(list_of_key.contains(key)) {
             int indexOfKey = list_of_key.indexOf(key);
             list_of_value.set(indexOfKey, value);
         } else {
             list_of_key.add(key);
             list_of_value.add(value);
         }
     }
 
     /**
      * Returns the value to which the specified key is mapped, or -1 if this map
      * contains no mapping for the key
      */
     public int get(int key) {
         if(list_of_key.contains(key)) {
             int indexOfKey = list_of_key.indexOf(key);
             return list_of_value.get(indexOfKey);
         }
         return -1;
     }
 
     /**
      * Removes the mapping of the specified value key if this map contains a mapping
      * for the key
      */
     public void remove(int key) {
         if(!list_of_key.contains(key)) return;
         int indexOfKey = list_of_key.indexOf(key);
         list_of_key.remove(indexOfKey);
         list_of_value.remove(indexOfKey);
     }
 }
 
 /**
  * Your MyHashMap object will be instantiated and called as such:
  * MyHashMap obj = new MyHashMap();
  * obj.put(key,value);
  * int param_2 = obj.get(key);
  * obj.remove(key);
  */