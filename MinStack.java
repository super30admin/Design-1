// Time Complexity : O(1) for push,pop,top and getMin operations.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First start with global minimum as infinity and while pushing an element to the stack if the element is less
// than global minimum then first add the global minimum to the stack and then the element itself and finally 
// update the global minimum with the element. If the element is greater than global minimum then just add the 
// element to the stack. While popping if the popped out element is equal to the gobal minimum then make one 
// more pop and assign it to global minimum or else just pop the element.

import java.util.Stack;

class MinStack {
    Stack<Integer> s = new Stack<Integer>();
    int min;
    public MinStack() {
        min = Integer.MAX_VALUE; 
    }
    
    public void push(int val) {
        if(val <= min){
            s.push(min);
            s.push(val);
            min = val;
        }
        else{
            s.push(val);
        }
    }
    
    public void pop() {
        if(s.pop() == min){
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
