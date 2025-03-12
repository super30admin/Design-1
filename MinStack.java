import java.util.ArrayList;
import java.util.List;

class MinStack {

// Time Complexity : O(1) 
// Space Complexity : O(n) as the ArrayList fills up
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  Saw the main hint in leet code "Consider each node in the stack having a minimum value." 
/* Apprach : used a List<int[currentInput, minElementInStackSoFar]> arrays to store the incommming requests 
 *  @ Every Push - compared the existing minElementInStackSoFar and updated the new enty if necessary
 *  @Pop - just removed the last elemtn in the ArrayList
 *  @GetMin & Top are basically the same but one will access the MIN Value while otehr will simply return the last val in list
*/

    List<int[]> minStack;
    public MinStack() {
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        int[] newTop = new int[]{val,val};
        int[] top = new int[2];
        if(minStack.size() == 0){
            minStack.add(newTop);
        } else if( minStack.size() > 0){
            top = minStack.get(minStack.size()-1);
            // [currentVal , stackMinVal]
            if(top[1] < newTop[1]) newTop[1] = top[1];
            minStack.add(newTop); 
        }
    }
    
    public void pop() {
        // if( minStack.size()-1 != 0){
            minStack.remove(minStack.size()-1);
        //} 
    }
    
    public int top() { // [currentVal , stackMinVal]
        int[] top = new int[2];
        //if( minStack.size()-1 == 0){
            top = minStack.get(minStack.size()-1);
            return top[0];
        //} 
    }
    
    public int getMin() { // [currentVal , stackMinVal]
        int[] top = new int[2];
        //if( minStack.size()-1 != 0){
            top = minStack.get(minStack.size()-1);
            return top[1];
        //} 
    }
}
