// Time Complexity : O(1) for every operation-> put,get,remove
// Space Complexity :O(n) -> For creating a new array of size given
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashMap {

    int[] map;
   public MyHashMap() {
    map = new int[1000000+1]; // given constraint is 10^6.


       Arrays.fill(map,-1);    // fill with -1 as constraints are positive
   }

   public void put(int key, int value) {

       map[key] = value;         // index of array is key and value at the index will be value;
   }


   public int get(int key) {
       if(map[key]!=-1)  // get value of the key from map  
           return map[key];
       return -1;   // return -1 if not found
   }


   public void remove(int key) {
       if(map[key]!=-1) {
           map[key] = -1; // unassign the value already set to -1
       }
   }
}
