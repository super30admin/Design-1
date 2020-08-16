// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.*;
class MinStack {
    Stack<int[]> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            //Store the val as the min.
            stack.push(new int[]{x,x});
            return;
        }
        //Get the current min.
        int currMin = stack.peek()[1];
        //Add the value along with minimum of val and current min.
        stack.push(new int[]{x,Math.min(x,currMin)});
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */