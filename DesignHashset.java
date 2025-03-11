// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyHashSet {
    private static final int SIZE = 1000;  // Number of buckets
    private LinkedList<Integer>[] storage; // Array of linked lists
   
       public MyHashSet() 
       {
           storage = new LinkedList[SIZE];
       }
       private int getIndex(int key)
       {
           return key%SIZE;
       }
   
       
       public void add(int key) {
           int index = getIndex(key);
           if (storage[index] == null) {
               storage[index] = new LinkedList<>(); // Create list if empty
           }
           if (!storage[index].contains(key)) {
               storage[index].add(key);  // Add key if not present
           }
       }
       
       public void remove(int key) {
          int index = getIndex(key);
           if (storage[index] != null) {
               storage[index].remove((Integer) key);  // Remove key if exists
           } 
       }
       
       public boolean contains(int key) {
            int index = getIndex(key);
           return storage[index] != null && storage[index].contains(key);
       }
   }
   
   /**
    * Your MyHashSet object will be instantiated and called as such:
    * MyHashSet obj = new MyHashSet();
    * obj.add(key);
    * obj.remove(key);
    * boolean param_3 = obj.contains(key);
    */