import java.util.*;

// Time Complexity : O(1) for all operations
// Space Complexity : O(N). Where N = size of stack.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/525769588/ 
// Any problem you faced while coding this : None.

class MinStack {
    
    private Stack<Integer> st;
    private int minVal = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
    }
    
    /** Keep track of min at all time
     * if element getting pushed is smaller than or equal to current min
     * push currentmin to stack update min 
     * push this element to stack
     */
    public void push(int val) {
        if(st.isEmpty() || minVal >= val)
        {
            st.push(minVal);
            minVal = val;
        }
        st.push(val);
    }
    
     /** Keep track of min at all time
     * if element getting popped is smaller than or equal to current min
     * pop the stack the next min will be the top of stack. update min using top
     * pop again as we added min while pushing this element.
     */
   public void pop() {
        if(st.peek() == minVal)
        {
            st.pop();
            minVal = st.peek();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek().intValue();
    }
    
    public int getMin() {
        return minVal;
    }
}
