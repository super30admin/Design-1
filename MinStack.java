import java.util.Stack;

class MinStack {
    
    int min;
    Stack<Integer> st;
    public MinStack() {
       st = new Stack<>();
       min = Integer.MAX_VALUE;
       st.push(min);
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        int valPopped = st.pop();
        if(valPopped == min){
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
