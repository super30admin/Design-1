import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n) = n+n two stack solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        
        if(!minStack.isEmpty())
        {    
            if(x<=minStack.peek())
                minStack.push(x);
        }
        else
            minStack.push(x);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        
        int current=stack.pop();
        if(current==minStack.peek())
            minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()) return -1;
        
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