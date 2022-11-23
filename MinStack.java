import java.util.Stack;

class MinStack {

    private Stack<Integer> minSt; 
    private Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        minSt.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
       st.push(val);
       int minTop = minSt.peek();
       if(val<=minTop){
           minSt.push(val);
        }
       }
    
    public void pop() {
    int top = st.pop();
    int topMin = minSt.peek();
    if(top==topMin)
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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