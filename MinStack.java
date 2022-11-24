// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    Stack<Integer> stMin;
    int minValue;

    public MinStack() {
        st = new Stack<>();
        stMin = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        st.push(val);
        if (val < minValue){
            minValue = val;
        }
        stMin.push(minValue);
    }
    
    public void pop() {
        st.pop();
        stMin.pop();
        if (stMin.size() == 0) {
            minValue = Integer.MAX_VALUE;
        } else {
            minValue = stMin.peek();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return stMin.peek();
    }

    public static void main (String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
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