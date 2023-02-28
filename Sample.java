// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

//Not while coding but I have difficulty figuring out the time complexity in general. 

// Your code here along with comments explaining your approach : 

//This code below sets the value of that key as true. Hence when we want to find if it is contained ,
//we return true as well. Similarly we set it to false in the remove function. So when we call contains on a removed 
//element, it returns false as expected. 

class MyHashSet {
    boolean[] a ;
        public MyHashSet() {
             a = new boolean[1000001];
        }
        
        public void add(int key) {
             a[key] = true;     
        }
        
        public void remove(int key) {
            a[key] = false;
        }
        
        public boolean contains(int key) {
            return a[key];
        }
    }
    