// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*  Initialized min with Integer.MAX_VALUE which is in java represents maximum positive value that can be represented is 2147483647.
    For push(): if element to be pushed is less than or eual to MAX_VALUE then we push it in stack and update min variable to that value. 
    Else if element to be pushed is greater than min variable value then directly push to stack.

    For pop(): Similar way, if item to be popped is equal to min variable value, store popped element to min variable.
    For top(): peek() operation gives the element at the top of stack
    For getMin(): Returns the Minimum element in stack which we can retrieve from min variable value.
*/


class MinStack {

    Stack<Integer> myStack = new Stack<Integer>();
    int min;

    public MinStack() {
       min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            myStack.add(min);
            min=val;
        }
        myStack.add(val);
    }
    
    public void pop() {
        if(myStack.pop() == min)
            min=myStack.pop();
    }
    
    public int top() {
         return myStack.peek();
    }
    
    public int getMin() {
         return min;
    }
}