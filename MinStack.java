// Time Complexity : O(1) for all user operations.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    int currMin;

    public MinStack() {
        stack = new Stack<>();
        this.currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(currMin >= val){
            stack.push(currMin);
            currMin = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == currMin){
            currMin = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return currMin;
    }
}
