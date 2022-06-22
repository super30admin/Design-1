// Time Complexity : O(1) for all methods
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> myStack;
    int min;
    
    public MinStack() {
        myStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        myStack.push(min);
    }
    
    public void push(int val) {
    	// If there is a new minimum, push old minimum and the new element
    	// Update the minimum
        if(val <= min){
            myStack.push(min);
            min = val;
        }
        myStack.push(val);
    }
    
    public void pop() {
    	// If the popped element is the minimum, 
    	// update the minimum to previous minimum by popping again
        if(min == myStack.pop()){
            min = myStack.pop();
        }
    }
    
    public int top() {
        return myStack.peek();
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