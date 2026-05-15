//Design a min stack
//Time Complexity : O(1)
//Space Complexity : O(n)

import java.util.Stack;

class MinStack {
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        //Push previous minimum & new minimum to stack when minimum changes
        if(min >= val) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if(min == minStack.pop()) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
