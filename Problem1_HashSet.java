// Time Complexity : For all three operations O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Little while deciding the size of array


// Your code here along with comments explaining your approach

/*  Initialized int array with size from (10^6 +1) to have elements from 0 to 10^6
    For add(): Incremented the value of key's index
    For remove(): Assigned zero to key's index
    For contains():if value is 0 element is not present else if value is not zero then element is present

*/


class MyHashSet {
        // Declaration
        int myArr[];
    public MyHashSet() {
        // Initializing the array to have elements from index 0 to 10^6
        myArr=new int[1000001];
    }
    
    public void add(int key) {
      myArr[key]=1;
    }
    
    public void remove(int key) {
       myArr[key]=0;
    }
    
    public boolean contains(int key) {
       if(myArr[key]==0) 
            return false;
        else 
            return true;
    }
}
