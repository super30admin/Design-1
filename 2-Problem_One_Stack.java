// 155. Min Stack - https://leetcode.com/problems/min-stack/
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to understand more about space complexity 

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min;
    
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min)
        {
            stack.push(min);      // store previous min value in the stack and add new one. When pop is performed we can access prev by this way
            min=val;
        }
        stack.push(val);          // store current min in stack
    }
    
    public void pop() {
        int val = stack.pop();
        if(min == val)
        {
            min = stack.pop();    // need to pop twice if this cond is satisfied cause min is stored twice as mentioned above. So one is popped.
        }
    }
    
    public int top() {
        return stack.peek();
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
