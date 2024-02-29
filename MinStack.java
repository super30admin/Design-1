
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None 
import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        this.minSt.push(min);
        this.st.push(val);
    }

    public void pop() {
        this.st.pop();
        this.minSt.pop();
        min = minSt.peek();
    }

    public int top() {
        return this.st.peek();
    }

    public int getMin() {
        return this.min;
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