//TC : O(1)
//SC : O(n)

class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.st=new Stack();
        this.minSt=new Stack();
        this.min=Integer.MAX_VALUE;
        this.minSt.push(min);
    }
    
    public void push(int val) {
        min=Math.min(min,val);
        st.push(val);
        minSt.push(min);
    }
    
    public void pop() {
        
        st.pop();
        minSt.pop();
        min=minSt.peek();
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