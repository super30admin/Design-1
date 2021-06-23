//Problem 2: Min stack
// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> min_vals=new Stack<>();
    
    public void push(int x) {
        if(min_vals.isEmpty() || x <= min_vals.peek())
        {
            min_vals.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.peek().equals(min_vals.peek()))
        {
            min_vals.pop();
        }
            
        
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_vals.peek();
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