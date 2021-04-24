// Time Complexity : O(1) for every operation-> push,pop,top,getMin
// Space Complexity :O(2n) -> For every element in stack we store 2 elements. value and its minimum
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class MinStack {

    Stack<int[]> stack; // Intializing to store value and min in the stack to keep track of  minimum at each and every operation
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        
        stack= new Stack<>();
        min=Integer.MAX_VALUE;
       
    }
    
    public void push(int val) {
        
       if(stack.isEmpty()){   // If stack is empty then minimum element will be value itself
           
           min=val;
           stack.push(new int[]{val,min});
       }
        else{
        stack.push(new int[]{val,Math.min(stack.peek()[1],val)}); // This is done because minimum element might have been popped out so current minimum is last updated min already in stack.
       }
    }
    
    public void pop() {
        
        stack.pop();  // Pop the top most element.
        
    }
    
    public int top() {
       return stack.peek()[0]; // Return the value in the top most element
    }
    
    public int getMin() {
       return stack.peek()[1]; // Return the min in the top most element.
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();