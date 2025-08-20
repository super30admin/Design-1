// Did this code successfully run on Leetcode : Yes
//TC: O(1) for all operations
//SC: O(1)
// Implemented using one stack and using formula 2 * val - prev_min = new_val(val is the val to be added which is the new min, prev_min is the previous minimum value in min and new_val is the value to be added to the stack instead of val )
// push - if stack is empty update min val and push to the stack, if val is < min push the value using the formula to the stack and update the min val to the val, else if val is > than min push to the stack
// pop - is stack is empty return, if the val is less than min decode using the formula and return the min val and update the min val with the decoded val and if the val is not less than min then pop the val 
// top - if val is less than min then return min else return top on stack
// getMin - return min val
import java.util.*;

class MinStack {

    private Stack<Long> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
            stack.push((long)val);
        }
        else if(val < min){
            int prevMin = min;
            stack.push((long)val * 2 - prevMin);
            min = val;
        } else {
            stack.push((long)val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        long removedVal = stack.pop();
        if(removedVal < min){
            min = (int)(2L * min - removedVal);
        }
    }
    
    public int top() {
        if(stack.isEmpty()){
            return min;
        } else if(stack.peek() < min){
            return min;
        } else {
            return (int)(long)stack.peek();
        }
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