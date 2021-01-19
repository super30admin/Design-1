import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Got confused when trying to figure out with arraylist so chose array.

// Your code here along with comments explaining your approach
class MyHashMap {

   private int[] pair;

   /** Initialize your data structure here. */
   public MyHashMap() {

      // this constraint is given in leetcode so followed it.
      pair = new int[1000000];
      Arrays.fill(pair, -1);

   }

   /** value will always be non-negative. */
   public void put(int key, int value) {

      pair[key] = value;

   }

   /**
    * Returns the value to which the specified key is mapped, or -1 if this map
    * contains no mapping for the key
    */
   public int get(int key) {
      return pair[key];
   }

   /**
    * Removes the mapping of the specified value key if this map contains a mapping
    * for the key
    */
   public void remove(int key) {

      pair[key] = -1;

   }
}