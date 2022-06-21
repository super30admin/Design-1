// Time Complexity : O(1) for push, pop and top as required. 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
//This solution is faster than only 10% of Java solutions. Needs to be improved. 
//Boundary cases were missed in the first attempts. 

// Your code here along with comments explaining your approach
// This is the two stack approach 

class MinStack {
    private Stack<Integer> stack = stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek()>= val)
            minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty())
            return 0;
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty())
            return 0;
        return minStack.peek();
    }
}
