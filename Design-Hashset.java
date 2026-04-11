// Time Complexity : O(1) for add, remove and contains
// Space Complexity : O(n) where n is the number of elements in the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We can use a boolean array to implement the hashset.
The index of the array will represent the key and when we add the key to the array, we will set the value true
When the remove function is called, we will mark the array[key] as false
When the contains function is called, we will return the value of the array[key]

*/
class MyHashSet {
    boolean[] array = new boolean[1000001];

    public MyHashSet() {
      
    }
    
    public void add(int key) {
        array[key] = true;
        
    }
    
    public void remove(int key) {
        array[key]=false;
    }
    
    public boolean contains(int key) {
        return array[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */