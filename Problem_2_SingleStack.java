//Leetcode problem - 155 (using one stack)
// Time Complexity : push(),pop(),top(),peek() : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min; //to store minmimum value
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE; //initialize a maximum value as min
       
    }
    
    /** if input is less than current minimum, push the current minimum to stack (to store historical minimum value) and assign min the new input. Also, push each element which is input
    */
    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min = x;
            
        }
       stack.push(x);
    }
    
    /** Pop the topmost element in the stack, check if its equal to the current min. In case it is equal, pop another element from the stack(which is the historical min value stored) and assign it as the new min.
    */
    public void pop() {
        int top = stack.pop();
        if(min == top)
            min = stack.pop();
       
    }
    
    /*return topmost element*/
    public int top() {
        return stack.peek();
    }
    
    /**return min currently*/
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
