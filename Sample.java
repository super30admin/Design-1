// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {
    int min;
    Stack<Integer> st;

    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
        
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(min == st.pop()){
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
