// Time complexity O(1) for all operations
// Space complexity O(n)
import java.util.*;
class MinStack {
    private Stack<Integer> st;
    private int min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(val<=min)
        {
            st.push(min);
            min=val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.pop()==min)
            min=st.pop();
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