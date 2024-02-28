//Time Complecity: O(1)
//Space Complexity: O(N) where N is total number of calls

class MinStack {
    private Stack<Integer> valStack;
    private Stack<Integer> minStack;
    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        valStack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek() ){
            minStack.push(val);
        }

    }
    
    public void pop() {
        if(valStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        valStack.pop();
    }
    
    public int top() {
        return valStack.peek();
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
