//Complexity : all operations are performed at constant time : O(1) and space complexity is O(2n) - O(n) since we are maintaining two stacks of same size

class MinStack {

    /** initialize your data structure here. */
    int min=Integer.MAX_VALUE;
    Stack<Integer> minStack = new Stack();
    Stack<Integer> stack = new Stack();
    
    public MinStack() {
        minStack.push(min);
    }
    
    public void push(int x) {
        if(x< min)
        {
            min=x; 
            
        }
        //even if the new value is not min, still push the old min in minStack for each value corresponding to stack, make diagram if you dont understand.
        minStack.push(min);
        stack.push(x);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min=minStack.peek();
       
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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
