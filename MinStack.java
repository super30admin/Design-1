// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    int min;
    Stack <Integer> s;

    public MinStack() {
        min = Integer.MAX_VALUE;        // Infinity
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min) {
            s.push(min);        // Storing the values and minimum in the same stack.
            min = val;
        }
        s.push(val);  
    }
    
    public void pop() {
        if(min == s.pop()) {     // If false, only a single pop takes place.
            min = s.pop();      // Pops the minimum value from the stack.
        }
    }
    
    public int top() {
        return s.peek();
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