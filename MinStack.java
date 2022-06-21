// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// Used stack and current min and pushed min when cur<= min

class MinStack {
    Stack<Integer> st;
    int min;
    public MinStack(){
        st = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    
    public void pop() {
        if(min==st.pop()){
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
