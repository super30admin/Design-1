// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    
    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(val,min);
        s.push(val);
        minStack.push(min);
        
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
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

