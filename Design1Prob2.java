// Time Complexity : O(1) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Unable to figure out solution using a single stack 


// Your code here along with comments explaining your approach : Took two stacks(one contain min elements at each insertion), for popping i'll pop element accordingly from minStack when min encountered min element 
class MinStack {

    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
        stack.push(x);
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek()))
            minStack.pop();
        stack.pop();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */