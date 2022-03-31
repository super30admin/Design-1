//Time Complexity : O(1)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class MinStack {
    //initialize a min value, two array's for stack values and min values
    int minValue= Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        //inserting the minimum value into the minStack
        minStack.push(minValue);
    }
    
    public void push(int val) {
        //on performing push operation, we will check the min values as well and then push
        if(val<=minValue)
            minValue=val;
        stack.push(val);
        minStack.push(minValue);        
    }
    
    public void pop() {
        //to remove the top of the element
        stack.pop();
        minStack.pop();
        //the next value in the min stack will be the min value
        minValue=minStack.peek();
        
    }
    
    public int top() {
        //top value in the stack
        return stack.peek();
        
    }
    
    public int getMin() {
        //min value of the stack
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