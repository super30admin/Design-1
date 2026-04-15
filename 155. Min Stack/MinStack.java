class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minst;
    private int min;

    public MinStack() {

        this.st = new Stack<>();
        this.minst = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minst.push(min); // setting minStack value to infinity
    }
    
    public void push(int val) {

        if(val < min){
            min = val;
        }

        st.push(val);
        minst.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minst.pop();
        min = minst.peek(); // set min value to minst top value i.e. the min value
    }
    
    public int top() {

        return st.peek();
        
    }
    
    public int getMin() {
        return min;
    }
}

// TC - O(1)
// SC - O(n)

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */