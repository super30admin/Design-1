// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None

class MyHashSet {
    
    boolean[] arr; // initialising a boolean array

    public MyHashSet() {
        arr = new boolean[1000001];  // array contains max 10^6 elements
    }
    
    public void add(int key) {       // bool=true if element is to be added  
        arr[key] = true;
    }
    
    public void remove(int key) {    // bool=false if element is to be removed
        arr[key] = false;
    }
    
    public boolean contains(int key) {  // display contained element
        return arr[key];
    }
}

