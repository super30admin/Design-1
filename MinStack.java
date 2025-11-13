// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes- Runtime 5 ms;Beats 47.52%
// Any problem you faced while coding this : yes - i forgot were to add intial min to min stack and my pop failed for a test case and then i corrected it


// Your code here along with comments explaining your approach
import java.util.Stack;
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        if(val < min)
        {
            min = val;
        }
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;

        int poppedVal = stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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