// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is number of elements in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;


    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if(val==min)
            min = stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
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