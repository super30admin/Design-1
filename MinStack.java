// Time Complexity :O(1) for push,pop,top,getMin
// Space Complexity : O(1)  for push,pop,top,getMin
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : faced null pointer exception, later resolved 


class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
     this.stack = new Stack<>();
     this.minStack = new Stack<>();
     this.min = Integer.MAX_VALUE; 
     this.minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        this.min = minStack.peek();
    }
    
    public int top() {
      return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
