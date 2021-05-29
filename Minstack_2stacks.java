// Time Complexity : O(1)
// Space Complexity : O(N) where N is number of values inserted in stack
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach

// Use 2 stacks where one stack has values and other has current minimum value. When current min is equal to 
// popped value, pop from minstack


class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack, minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        // Update min if x <= min
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }
    
    public void pop() {
        // Pop from minstack if stack top and minstack top are equal
        if(stack.peek().equals(minStack.peek()))
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