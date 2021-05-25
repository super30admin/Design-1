// Time Complexity : O(1) (Because we are only doing operations to pop(last element but not other elements) and push the elements)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried using linkedlists at first but found issues when storing the min elements.


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st, min;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(val <= getMin()) {
            min.push(val);
        }
    }
    
    public void pop() {
        int poppedvalue = st.pop();
        if(poppedvalue == getMin()) {
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.isEmpty() ? Integer.MAX_VALUE : min.peek();
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