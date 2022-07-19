// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Create two stacks, one to hold the actual values, the other to hold the minimum values
// 2. For every push, check to see if the current value is less than or equal to the top value of the min stack (if it is not empty). The idea is everytime a new minimum is encountered, it is recorded in the min stack
// 3. For removal, remove from the stack and if the value to be removed is equal to the top element of the min stack, remove that value as well as it won't be the accurate min value
// 4. For the top element, return the top element from stack and for min return the top element of min stack

class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int deletedElement = stack.pop();
        if(deletedElement == minStack.peek()) {
            minStack.pop();
        }
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