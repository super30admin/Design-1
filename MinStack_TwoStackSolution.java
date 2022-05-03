import java.util.*;

class MinStack {
    //Two stack solution
    // Time complexity is O(1)
    // Space Complexity is O(n)
    // Solution is submitted to leetcode with no errors

    private Stack<Integer> inStack;
    private Stack<Integer> minStack;
    int min;
    public MinStack() {
        this.inStack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        inStack.push(val);
        if(val< min){
            minStack.push(val);
            min = val;
        } else
            minStack.push(min);
    }
    
    public void pop() {
        inStack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return inStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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