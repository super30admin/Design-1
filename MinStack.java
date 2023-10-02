/* Time Complexity : 
 * each of push, pop, top, getMin - O(1)*/
/* Space Complexity : 
 * each of push, pop, top, getMin - O(1)*/
// Did this code successfully run on Leetcode : - Yes
// Any problem you faced while coding this :

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack; // Hold the values
    private Stack<Integer> minStack; // Hold the minimum value of all the values present in first stack
    private int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
        minStack.push(min);
    }
    
    public void push(int val) {
        stack.push(val);
        int currentMin = getMin();
        //If current min is greater than val ,insert val in the minStack
        if(currentMin > val){
            minStack.push(val);
        }
        else{
            minStack.push(currentMin);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
