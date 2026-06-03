import java.util.Stack;

class MinStack {
    /*
        Initialize min to int max. When inserting value that is less than or equal to min,
        we will first push the previous min value into the min stack and then push the current value.
        Similarly, when popping value from stack, if the popped value is equal to the min value, 
        then we again pop an element and assign that as the min value.

        // Time Complexity : push, pop, peek, getMin - O(1)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
    */


    private Stack<Integer> minSt;
    int min;

    public MinStack() {
        minSt = new Stack<>();
        min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) {
        if (val <= min) {
            minSt.push(min);
            min = val;
        }
        minSt.push(val);
    }
    
    public void pop() {
        int val = minSt.pop();
        if (val == min) {
            min = minSt.pop();
        }
    }
    
    public int top() {
        return minSt.peek();
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