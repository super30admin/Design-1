// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing specific

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();                              //main stack
        minStack = new Stack<>();                           // stack to keep track of minimum
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {     //if the element is less than minstack top element(min), push it 
            minStack.push(x);
        }
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) minStack.pop();    //pop  if stack and minstack's top ele is same
        stack.pop();
    }
    
    public int top() {
        return stack.peek();                                          
    }
    
    public int getMin() {
        return minStack.peek();                                  //minstack peek maintains the min ele on top
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