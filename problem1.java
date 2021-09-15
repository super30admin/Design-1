// Time Complexity : adding,removing takes o(1),
// Space Complexity :o{100001)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes regarding the data structure because at first I used integer array solution accepted but not all cases then I used arraylist but got out of bonds error. Then finally use boolean type array.


// Your code here along with comments explaining your approach:- in addition element is adding so at that position keeping true, and at removing element is not there means false. based on this values in contains just returning that values is enough right.








class MyHashSet {

    /** Initialize your data structure here. */
   boolean[] a ;
    int MAX;
    public MyHashSet() {
        MAX = 1000001;
        a=new boolean[MAX];
        
        
        
        
    }
    
    public void add(int key) {
      a[key]=true;
         
    }
    
    public void remove(int key) {
        a[key]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return a[key];}
}