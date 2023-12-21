
//Using single stack. THis will modify the input stack
//SC: Worst case remains the same but average case is O(1) 
class MinStack {
    Stack<Integer> st;
    int min;


    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();        
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
            st.push(val);
    }
    
    public void pop() {
        if(st.pop() <= min)
        {
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