import java.util.*;
//Exercise_2 : Design Minstack
// Time Complexity : O(1)  -> for all operations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

//Note: I used Stack Data Structure and single stack of type int array where I'm storing new value in first index and the minimum value in second index.

/**** Steps ****/
/*

1) Created a global Stack object of type int array, so that value can be stored in first index and minimum value can be stored in second index
2) Push :  --> O(1)
      a) Check whether stack is empty or not. 
      b) If it is not empty insert insert the new value with the minimum value of (new value or stack.peek() value).
      c) If stack is empty insert the new value with the new value as minimum.
3) Pop : --> O(1)
      - Use stack.pop() method
4) Top:  --> O(1)
      - Use stack.peek() method
5) GetMin --> O(1)
      - Return value on second index of stack.peek()
       
*/

class MinStack {

    /** initialize your data structure here. */
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        //TC: O(1), SC : O(n)
        if(!stack.isEmpty()){
            stack.push(new int[]{x,Math.min(x,stack.peek()[1])});
        }else{
            stack.push(new int[]{x,x});
        }
    }
    
    public void pop() {
        //O(1)
        stack.pop();
    }
    
    public int top() {
        //O(1)
        return stack.peek()[0];
    }
    
    public int getMin() {
        //O(1)
        return stack.peek()[1];
    }
}
