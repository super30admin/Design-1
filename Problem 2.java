// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Did not understand before the class at all, but have a fairly good idea now


class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private int min;
    

    /** initialize your data structure here. */
    public MinStack(){
        st = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    
    void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minStack.push(min);
    }
    
    void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    int top() {
        return st.peek();
    }
    
    int getMin() {
        return min;
    }
}
