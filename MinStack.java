//Time Complexity: O(1)

// Did this code successfully run on Leetcode : Yes

class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE; //setting to max value to avoid checking arr.IsEmpty()
        minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min, val); //Compute the min with current value
        s.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek(); //Set min to minStack's top after pop operation
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