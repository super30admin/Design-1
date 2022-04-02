import java.util.Stack;

class MinStack {
    // Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minstack;
    int min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minstack = new Stack<>();
        minstack.push(min);
    }

    public void push(int val) {
        if(val <= min){
            min = val;
        }
        stack.push(val);
        minstack.push(min);
    }

    public void pop() {
        stack.pop();
        minstack.pop();
        min = minstack.peek();
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