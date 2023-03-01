//time complexity : O(1)
//Space complexity : O(n)
//executed successfully on leetcode

public class MyHashSetWithoutHashFunction {

    boolean arr[];
    public MyHashSet() {
        //create an array
        arr= new boolean[20000000];
    }
    
    public void add(int key) {
        // set true in the array index (index = key)
        arr[key]= true;
    }
    
    public void remove(int key) {
         // set false in the array index (index = key)
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        //if at particular index array is true then it contains the key
        if(arr[key] == true){
            return true;
        }
            else{
                return false;
            }
        }
 }
