// Time Complexity : O(n) 
// Space Complexity : O(n) arraylist is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 403 error while pushing it. so I added directly 
// Your code here along with comments explaining your approach
// Design a HashSet without using any built-in hash table libraries.
// Implement MyHashSet class:
// void add(key) Inserts the value key into the HashSet.
// bool contains(key) Returns whether the value key exists in the HashSet or not.
// void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

import java.util.*; 
class hash{
        static class MyHashSet {
        static ArrayList<Integer> arr;
        public MyHashSet() {
            arr=new ArrayList<>();
        }
        
        public void add(int key) {
            if(!arr.contains(key))
                arr.add(key);
                
        }
        
        public void remove(int key) {
             if(arr.contains(key))
                 arr.remove(arr.indexOf(key));
        }
        
        public boolean contains(int key) {
            return arr.contains(key);
        }
    public static void main(String [] args){
        MyHashSet hashset = new MyHashSet();
    hashset.add(1);         
    hashset.add(2);         
    hashset.contains(1);    // returns true
    hashset.contains(3);    // returns false (not found)
    hashset.add(2);          
    hashset.contains(2);    // returns true
    hashset.remove(2);          
    hashset.contains(2);    // returns false (already removed)
    }
}
}

