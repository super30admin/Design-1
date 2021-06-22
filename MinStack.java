// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//I am using two stacks to implement the Min Stack. 
//First stack contains all the elements pushed into the stack. 
//Second stack is used to keep track of the minimum element in the stack.

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minTrackerStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minTrackerStack = new Stack<>();
    }
    
    public void push(int val) {
        
        stack.push(val); //new value pushed onto the top of the stack.
        
        //if minTrackerStack is empty, then first value is considered as minimum value and pushed into minTrackerStack.
        if(minTrackerStack.isEmpty()){
            minTrackerStack.push(val);
        }
        
        //if the new value is smaller than or equal to top value of the minTrackerStack, then it is pushed into minTrackerStack
         else if( val <= minTrackerStack.peek()) {
            minTrackerStack.push(val);
        }
    }
    
    public void pop() {
        
        //if top element on stack and minTrackerStack is same, then pop the top element in minTrackerStack.
        if(stack.peek().equals(minTrackerStack.peek())){
            minTrackerStack.pop();
        }
        
        //pop top element in the stack
        stack.pop();
    }
    
    public int top() {
        
        return stack.peek(); // returns the top element.
    }
    
    public int getMin() {
        
        return minTrackerStack.peek(); //return the top element.
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
