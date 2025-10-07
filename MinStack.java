// Design Min Stack
// https://leetcode.com/problems/min-stack/

// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()){  // If minStack is empty or current value is less than or equal to last value of stack
            minStack.push(val);  // add to min stack
        }

        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek())){ // if last value of both stacks are same, pop them
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}