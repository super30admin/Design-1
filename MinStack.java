// O(1) time complexity for all operations
// O(n) space complexity

import java.util.Stack;

class MinStack {
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= min) {
            minStack.push(min); // push min
            min = val;
        }
        minStack.push(val); // push val as it tracks curr min
    }
    
    public void pop() {
        int popped = minStack.pop();
        if (popped == min) {
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

