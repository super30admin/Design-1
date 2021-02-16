class MinStack {

    // Extra space complexity: O(n)
    
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int minVal;
    
    public MinStack() {
        stack = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }
    
    // Time Complexity: O(1)
    public void push(int x) {
        if(x <= minVal){
            stack.push(minVal);
            minVal = x;
        }
        stack.push(x);
    }
    
    // Time Complexity: O(1)
    public void pop() {
        int curr = stack.pop();
        if(curr == minVal)
            minVal = stack.pop();
    }
    
    // Time Complexity: O(1)
    public int top() {
        return stack.peek();
    }
    
    // Time Complexity: O(1)
    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */