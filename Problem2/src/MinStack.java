// Time Complexity :
//Push O(n)

//// Space Complexity :
//O(1) Not sure, please let me know if its correct
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to initialize the bucketItem array which caused an issue, resolution took 5 min.
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
    stack.push(x);
    int minval = Math.min(x,minStack.peek());
    minStack.push(minval);
    }

    public void pop() {
    stack.pop();
    minStack.pop();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */