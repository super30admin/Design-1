// Time Complexity : O(1) for all operations
// Space Complexity : O(n) (n-number of elements)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

class MinStack {
    
    Stack<Integer> stack;
    Stack<int[]> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        
        if(minStack.isEmpty() || val < minStack.peek()[0])
            minStack.push(new int[]{val,1}); //this will be the first occurrence of the element
        else if(val==minStack.peek()[0])
            minStack.peek()[1]++; //incrementing the count if the incoming element equals the top element of minStack
        stack.push(val);
        
    }
    
    public void pop() {
        if(minStack.peek()[0] == stack.peek())
            minStack.peek()[1]--; //decrementing the count of min stack when popped element from the main stack is equal to the minStack peek element
        if(minStack.peek()[1]==0) //if this min element doesn't exist anymore, pop it
            minStack.pop();
        
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek()[0];
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