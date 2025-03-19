


class MinStack {

    Stack<Integer> st;
    Stack<Integer> minst;
    int min;

    public MinStack() {
        
        this.st=new Stack<>();
        this.minst=new Stack<>();
        this.min = Integer.MAX_VALUE;
        minst.push(min);
    }
    
    public void push(int value) {
        min = Math.min(min,value);
        st.push(value);
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
