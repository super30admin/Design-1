// Time Complexity : O(1) - For accessing the element
// Space Complexity : O(1000000)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initialy I used the linked list approach but the problem did not run successfully.
// I needed a better understanding of linked list implementation


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[] arr; 
    public MyHashSet() {
        // the size is defined as the constraint on value of the input key is 1<key<1000000
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        // Update the index of the array as true considering the index itself as the key
        arr[key] = true;
    }
    
    public void remove(int key) {
        // By default the value is anyway false and if at all the arr[key] is true, it will be again set to false
        arr[key]=false;
    }
    
    public boolean contains(int key) {
        // Return true if the index value in that array is set to true concluding the key is already added
       return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
