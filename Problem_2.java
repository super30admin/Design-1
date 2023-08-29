/* 

Problem 1: Design MinStack (https://leetcode.com/problems/min-stack/)

Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Implemented using a single stack by push the initial infinte value as min and there on pushing either both min and value
or only the value depending on if the value is lesser than or equal to the current min value.

*/

class MinStack {
    Stack<Integer> MinStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        MinStack = new Stack<Integer>();
        MinStack.push(min);
    }
    
    public void push(int val) {
        if(val <= min){
            MinStack.push(min);
            min = val;
        }
        MinStack.push(val);
    }
    
    public void pop() {
        if(MinStack.pop() == min){
            min = MinStack.pop();
        }
    }
    
    public int top() {
        return MinStack.peek();
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