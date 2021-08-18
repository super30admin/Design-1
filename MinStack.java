// Time Complexity : O(1)
// Space Complexity : 0(n) -  n is the number of input values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was not able to do the getMin function in the starting in o(1) time, only approach that was coming in mind was to traverse the stack to find minimum before coming upon the current solution

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Pair<Integer, Integer>> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        stack.push(new Pair<>(val, min));
    }
    
    public void pop() {
        stack.pop();
        if(stack.size() == 0) min = Integer.MAX_VALUE;
        else min = stack.peek().getValue();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
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
 