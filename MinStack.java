// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MinStack {

    //create single stack and min tracker
    //when min is larger than current val, push both values onto stack and set min to curr val
    //when popping off the current min value, the previous min val will become the curr.
    Stack<Integer> st = new Stack<>();
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min >= val){
            st.push(min);
            min = val;
        }
        st.push(val);
        
    }
    
    public void pop() {
        if(st.pop() == min){
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
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