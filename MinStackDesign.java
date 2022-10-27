//time complexity is O(1)
//space complexity is O(N)
//able to submit the in leetcode
class MinStack {
    Stack<int[]> st = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty())
        {
            st.push((new int[]{val, val}));
        }
        else{
            int[] temp = st.peek();
            st.push(new int[] {val, Math.min(val, temp[1])});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
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
