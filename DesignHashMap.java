// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was difficult to think of an approach and especially thinking of a data structure to use 


// Your code here along with comments explaining your approach

class MyHashMap {
   
    int[] map;
    
     MyHashMap() {
        map=new int[1000001];  
         Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
       map[key]=value;
    }

    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key]=-1;
    }
}
