// ## Problem 1:(https://leetcode.com/problems/design-hashset/)

// Time Complexity : O(1)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes
// Summarized approach: 
// We make use of hashing functions to generate indexes which we use to store and retrieve the elements in O(1) time
// There are a few ways you can avoid collision during hashing, and here we use a second hashing function i.e. double hashing.
// i.e. A secondary array is used to maintain items with same modulo values but allocated individual index in the secondary array based on the second hashing function.
// We could use a linear array with size 10^6 insead of this matrix as well, but with the matrix approach, we can allocate memory for the secondary array for a bucket as and when needed so it is slightly more optimized.

// Any problem you faced while coding this : Edge case for when the "0"th bucket items needing extra space.


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean arr[][]; // Storage array with max size 10^6
    private int buckets;
    private int bucketItems;
 
     public MyHashSet() {
         this.buckets = 1000;
         this.bucketItems = 1000;
         this.arr = new boolean[buckets][];
     }
     
     public void add(int key) {
         int bucket = hash1(key);
         int bucketItem = hash2(key);
         if (arr[bucket] == null) {
             // For the 0 bucket, index will from 0 to 999 but for the 10^6th entry, we need an extra slot in the array. 
             if (bucket == 0) {
                 arr[bucket] = new boolean[bucketItems + 1];
             } else {
                 arr[bucket] = new boolean[bucketItems];
             }
         }
         arr[bucket][bucketItem] = true;
     }
     
     public void remove(int key) {
         int bucket = hash1(key);
         // If the bucket has a null reference, it has no secondary array i.e. no elements so nothing to remove
         if (arr[bucket] == null) {
             return;
         } 
         int bucketItem = hash2(key);
         arr[bucket][bucketItem] = false;   
     }
     
     public boolean contains(int key) {
         int bucket = hash1(key);
         int bucketItem = hash2(key);
        // If the bucket has a null reference, it has no secondary array i.e. no elements so nothing to remove
         if (arr[bucket] == null) {
             return false;
         } else {
             return arr[bucket][bucketItem];
         }
     }
 
     // Helper function for modulo operation
     private int hash1(int key) {
         return key%buckets;
     }
 
     // Helper function for divide operation
     private int hash2(int key) {
         return key/buckets;
     }

     public static void main(String args[]) {
        MyHashSet obj = new MyHashSet();
        obj.add(10);
        obj.add(50);
        System.out.println(obj.contains(10));
        obj.remove(10);
        System.out.println(obj.contains(10));
      }
 
 }
 
 /**
  * Your MyHashSet object will be instantiated and called as such:
  * MyHashSet obj = new MyHashSet();
  * obj.add(key);
  * obj.remove(key);
  * boolean param_3 = obj.contains(key);
  */
