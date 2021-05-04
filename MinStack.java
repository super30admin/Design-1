// Time Complexity : O(1) for every operation-> push,pop,top,getMin
// Space Complexity :O(n) -> For creating stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {


    // Using 2 stacks. One is for maintaining minimum element at the top the stack
    // and the other one is to maintain all the elements
    /** initialize your data structure here. */
    Stack <Integer> stack = new Stack<>();

   Stack <Integer> minStack = new Stack<>();

   int min = Integer.MAX_VALUE;
    public MinStack() {
    
        minStack.push(min);// Initializing minStack with the maximum value
    }
    
    public void push(int val) {
        stack.push(val); //Pushing new element into the stack
        if(val<min){
            min=val; //If the current element is less than the previous minimum, new minimum is set and that's pushed into minstack
        }
        minStack.push(min);//If the current element is not less than the previous minimum, the previous minimum val is pushed into the minStack again
    }
    
    public void pop() {
        stack.pop();    //popping the element from stack
        minStack.pop();     //popping the element from minStack
        min=minStack.peek();    //New minimum will be the top element of the minStack
        
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
