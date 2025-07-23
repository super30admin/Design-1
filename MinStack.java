class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>(); // Taking stack just to maintain minimum value
    }

    public void push(int val) {
        // Time Complexity : o(1)

        st.push(val);
        /* comparing top value of original stack with top min stack , whichever is small is stored as min value against each value in min stack
         */
        if( minSt.isEmpty() ){
            minSt.push(val);
        }
        else{
            if( st.peek() < minSt.peek() ){
                minSt.push( st.peek() );
            }
            else{
                minSt.push( minSt.peek() );
            }
        }

    }

    public void pop() {
        // Time Complexity : o(1)
        st.pop();
        minSt.pop();
    }

    public int top() {
        // Time Complexity : o(1)
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