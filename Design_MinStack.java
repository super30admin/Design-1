// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach 1 - 1:1. We use stack for this. We maintain a main stack that has push, pop and peek operations. We also maintain a min stack
//that has all the min values. The first value pushed will be as infinity so that we don't have to check if the stack is empty and when it is min value is infinity.
import java.util.Stack;

class MinStack {

    private int minValue;
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        this.minValue = Integer.MAX_VALUE;
        this.st = new Stack<Integer>();
        this.minSt = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        minValue = Math.min(minValue, val);
        minSt.push(minValue);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        minValue = minSt.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minValue;
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
//Approach 2 : This approach will store the min values below the actual values. This approach will not need two different stacks. 
// If the min value is greater of equal to the current value then that value becomes the min value. For pop if the min value is equal 
//to the popped value then we return the previous value as the minimum value.

class MinStack {

    private int minValue;
    private Stack<Integer> st;

    public MinStack() {
        this.minValue = Integer.MAX_VALUE;
        this.st = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(minValue >= val){
            st.push(minValue);
            minValue= val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(minValue == st.pop()){
            minValue = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minValue;
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