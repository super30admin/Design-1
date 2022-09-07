// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

import java.util.Stack;

class MinStack {
    Stack<Integer> min;
    Stack<Integer> stack;
    int size;
    int topStack;
    int topMin;
    public MinStack() {
        min = new Stack<Integer>();
        stack = new Stack<Integer>();
        size = 100;
        topStack = -1;
        topMin = -1;
    }
    
    public void push(int val) {
        int minval = val;
        stack.push(val);
        topStack++;
        if (!min.isEmpty() && min.peek() < minval) {
            minval = min.peek();
        }
        min.push(minval);
        topMin++;
    }
    
    public void pop() {
        stack.pop();
        min.pop();
        topStack--;
        topMin--;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

    public boolean isEmpty() {
        return (topStack == -1);
    }

    public boolean isFull() {
        return (topStack == size - 1);
    }
}