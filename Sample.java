// Time Complexity :O(1) average, O(n) worst case
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I took the help of a 
// video to understand the concept of hash map and how to implement 
// it using separate chaining approach.
// Your code here along with comments explaining your approach
// Seperate chaining approach to handle collisions in hash map
// Linked List is used to store the key value pairs
// Rehashing is done when the load factor exceeds 0.75

import java.util.LinkedList;



class MyHashSet {
    class Entry{
        public int key;
        public Entry(int key){
            this.key = key;
        }   
    }
   LinkedList<Entry>[] set;
   public static int size = 769;
    public MyHashSet() {
        set = new LinkedList[size];
    }
    
    public void add(int key) {
        int bucket = (key % size);
        if (set[bucket] == null) set[bucket] = new LinkedList<>();
        for (Entry e : set[bucket]) {
            if (e.key == key) return;
        }
        set[bucket].addLast(new Entry(key));
    }
    
    public void remove(int key) {
        int bucket = (key % size);
        if (set[bucket] != null) {
            Entry toRemove=null;
        for (Entry e : set[bucket]) {
            if (e.key == key)
            {
                toRemove=e; 
                break;
            }
        }
         if(toRemove!=null) set[bucket].remove(toRemove);
        }
           
       
    }
    
    public boolean contains(int key) {
        int bucket = (key % size);
        if (set[bucket] != null) {
            for (Entry e : set[bucket]) {
                if (e.key == key) return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */