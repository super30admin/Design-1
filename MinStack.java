// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(min.empty() || x <= min.peek())
        {
            min.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.peek() == min.peek())
        {
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
