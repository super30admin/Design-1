// Time Complexity : o(1)
// Space Complexity : o(n) where n is max number elements pushed
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class MinStack {
    int min;
    Stack<Integer> stk;
    Stack<Integer> minStack;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stk = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }
    
    public void push(int val) {
        stk.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        if(stk.size() == 0) return;
        stk.pop();
        minStack.pop();
    }
    
    public int top() {
        return stk.peek();
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