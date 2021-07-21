import java.util.Stack;

// Time Complexity : O(1) for push,pop,top,getMin
// Space Complexity : O(n)

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min  = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        if (val < min) {
            min = val;
        }
        stack.push(val);
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