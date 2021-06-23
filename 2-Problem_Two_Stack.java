// 155. Min Stack - https://leetcode.com/problems/min-stack/
// Time Complexity : O(1)
// Space Complexity : O(2N) ~ O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to understand more about Stack inbuilt functions provided by java

class MinStack {

    /** initialize your data structure here. */ //Two Stack
    Stack<Integer> stack,minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE); //minStack is null at first so we return max of push
    }
    
    public void push(int val) {
        if(val <= minStack.peek())
        {
            minStack.push(val);
        }
        else
        {
            minStack.push(minStack.peek());
        }
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
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