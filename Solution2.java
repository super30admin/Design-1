// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        st= new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val>min){
            st.push(val);
        }

        // to track previous min value if min value is popped 
        else{
            st.push(min);
            st.push(val);
            min=val;
        }
    }
    
    public void pop() {
        int temp=st.pop();
        if(temp==min){
            min=st.pop();
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