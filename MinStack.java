// Time Complexity :o(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int x) {
        min = Math.min(min, x);
        st.push(x);
        minSt.push(min);
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
            minSt.pop();
            min = minSt.peek();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}