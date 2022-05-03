import java.util.*;

class MinStack {
    // One Stack Solution
    // Time complexity is O(1)
    // Space Complexity is O(n)
    // Solution is submitted to leetcode with no errors
    
    private Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }
    
    public void pop() {
        if (min == minStack.pop()) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */