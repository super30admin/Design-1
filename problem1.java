// Time Complexity : faster than 26.27% of Java submissions 
// Space Complexity : less than 5.15% of java submissions
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Inefficient

class MyHashSet {
    
    private int[][] arr1;
    private int[] arr2;
    
    public MyHashSet() {
        arr1 = new int[1001][1001];
        arr1[0][0] = -1;
        
    }
    
    // public void hashc(int key){
    //     a = key/1000
    // }
    
    public void add(int key) {
        arr1[key/1001][key%1000] = key;  
       
    }
    
    public void remove(int key) {
        if (contains(key)){
           arr1[key/1001][key%1000] = -1; 
        }
        
    }
    
    public boolean contains(int key) {
        if (arr1[key/1001][key%1000] == key){
            return true;
        }
        else{
            return false;
        }
        
    }
}