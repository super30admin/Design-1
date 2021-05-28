// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Already had solved this problem before, so none


// Your code here along with comments explaining your approach

class MinStack {

    /*Create a variavble to store the minimum value entered in the stack*/
    int min = Integer.MAX_VALUE;
    
    Stack<Integer> stack = new Stack<Integer>();
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    /* Check if the value x is less than min value. If yes, first push min value and then push x.
        And then just push value x. Here, minimum value will change only if incoming value is less than current */
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        
        stack.push(x);
    }
    
    /*If pop results in changing current minimum value, then double pop*/
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */