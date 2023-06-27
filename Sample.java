// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Using a boolean array to keey the track of each unique key. 
//push: Sets true at the index of the element passed
//remove: sets false at the index of the element passed
//contains: returns the boolean value of the given index
class MyHashSet {

boolean[] arr;
    public MyHashSet() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}
