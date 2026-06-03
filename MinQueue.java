// Time Complexity : O(1) for push, O(1) for min and O(1) for top
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
    
class MinStack {

    int min;
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        
        this.min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(min,val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
