import java.util.HashSet;
// Time Complexity : 
//  add(key): O(1) on average
//  remove(key): O(1) on average
//  contains(key): O(1) on average

// Space Complexity : 
//  O(N), where N is the number of unique elements added to the HashSet

// Did this code successfully run on Leetcode? 
//  Yes

// Any problem you faced while coding this? 
//  No, the implementation is straightforward as it uses Java's built-in HashSet

// Your code here along with comments explaining your approach:
//  - This class 'MyHashSet' uses Java's HashSet to implement the basic functionality of a set.
//  - The add method inserts an element into the set.
//  - The remove method deletes an element from the set.
//  - The contains method checks if an element exists in the set.
//  - Java’s HashSet handles hashing internally, so we get constant time for all operations on average.


class MyHashSet {
    HashSet<Integer> set;
    
    // Constructor initializes the internal HashSet
    public MyHashSet() {
        set = new HashSet<>();
    }
    // Adds a key to the HashSet
    public void add(int key) {
        set.add(key);
    }
    // Removes a key from the HashSet if it exists
    public void remove(int key) {
        set.remove(key);
    }
    // Returns true if the HashSet contains the specified key
    public boolean contains(int key) {
        return set.contains(key);
    }

    public static void main(String[] args) {
        // Your MyHashSet object will be instantiated and called as such:
         MyHashSet obj = new MyHashSet();

         // Add elements
         obj.add(1);
         obj.add(2);
         obj.add(3);
         obj.add(1); // Duplicate, will be ignored
         obj.add(6);

         // Print current set
         System.out.println("After Creating HashSet: " + obj.set);

         // Remove element 6
         obj.remove(6);
         System.out.println("After removal HashSet: " + obj.set);

         // Check if 6 exists
         boolean param_3 = obj.contains(6);
         System.out.println("Set does contain 6? : " + param_3);

         // Check if 1 exists
         boolean param_4 = obj.contains(1);
         System.out.println("Set does contain 1? : " + param_4);
    }
}