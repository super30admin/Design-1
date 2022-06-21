// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// created an boolean array to keep track of items
public class MyHashSet {
    boolean[] array = new boolean[1000001];
    
    public MyHashSet() {        
    }
    
    public void add(int key) {
        array[key] = true;        
    }
    
    public void remove(int key) {
        array[key] = false;
    }   

    public boolean contains(int key) {
        return array[key];
    }
}