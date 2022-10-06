package S30_Codes.Design_1;

// Time Complexity : O(1) for all operation
// Space Complexity : O(n)
// Design - 1

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        //stack.push(min);
    }

    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();

        if(val == min){
            min = stack.pop();
        }
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
