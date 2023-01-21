// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//To implement MinStack we use a stack and a variable to store the min value
//we push the min value before pushing the new value to the stack if the new value is less than the min value to keep track of previos min
//we pop the min value if the value to be popped is equal to the min value

class MinStack {
    Stack <Integer> st ;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(val<=min)
        {
            st.push(min);
            st.push(val);
            min=val;
        }
        else
        {
            st.push(val);
        }        
    }
    
    public void pop() {
        if(st.pop()==min)
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */