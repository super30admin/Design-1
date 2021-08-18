class MinStack {

    /** initialize your data structure here. */
    Stack <Integer> st;
    int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
        st.push(min);
    }
    
    public void push(int val) {
       if(val <= min)
       {
           st.push(min);
           min = val;
       }
        st.push(val);
    }
    
    public void pop() {
        if (min == st.pop())
        {
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

// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
