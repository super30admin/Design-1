// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach : created two stacks, one to store the elements and the other to store the minimum element if the minimum value changes.

class MinStack {
    
    Stack st;
    Stack min_st;
    public MinStack() {
        st = new Stack();  //creating stack
        min_st = new Stack(); // creating another stack to store minimum value everytime a element is pushed
        min_st.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        st.push(val);
        if(val <= (Integer)min_st.peek()){
            min_st.push(val);
        }
    }
    
    public void pop() {
        int min = (Integer)st.pop();
        if(min == (Integer)min_st.peek()){
            min_st.pop();
        }
    }
    
    public int top() {
        return (Integer)st.peek();
    }
    
    public int getMin() {
        return (Integer)min_st.peek();
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