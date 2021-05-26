// Time Complexity : O(n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {

    private Stack<Integer> minStack;
    private int minimum;
    /** initialize your data structure here. */
    public MinStack() {
        
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE); //to handle stack empty exception
        minimum = Integer.MAX_VALUE;
    }
    
// if value is less than or equal, push value along with previous minimum value to keep track of previous minimum value incase of minimum value is poped.
    public void push(int val) {
        if(val <= minimum) {
            minStack.push(minimum);
            minimum = val;
        }
         minStack.push(val);
    }
    
//If poped value is the current minimum, pop previous minimum from stack and make it as current minimum.
    public void pop() {
       
        if(minStack.pop() == minimum)
            minimum = minStack.pop();
    }
    
    public int top() {
        return minStack.peek();      //get stack top element
    }
    
    public int getMin() {
        return minimum;            //return global minimum
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