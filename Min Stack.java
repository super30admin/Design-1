import java.util.Stack;
class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minst;
    private int min;
    public MinStack() {
        
        st = new Stack<>();
        minst = new Stack<>();
        min = Integer.MAX_VALUE;
        minst.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minst.push(min);
    }
    
    public void pop() {
        st.pop();
        minst.pop();
        min = minst.peek();
    }
    
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return min;
    }
}