class MinStack {

    Stack<Integer> st;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer> ();
        st.push(min);
    }
    
    public void push(int val) {
      
        if (val < min){
            min = val;
            System.out.println ("New Min: "+min);
        }else {
            System.out.println ("Val < Min: "+min);
        } 
       
        st.push(val);
        st.push(min);
        System.out.println ("Pushing Val: "+val+ " Min: "+min);
    }
    
    public void pop() {
        System.out.println ("Popping Min: "+st.pop());
        System.out.println ("Popping Val: "+st.pop());
        min = st.peek();
    }
    
    public int top() {
        int min = st.pop();
        System.out.println ("Popping Min before Popping top Val: "+min);
        int top = st.peek();
        st.push(min);
        System.out.println("Top: "+top);
        return top;
    }
    
    public int getMin() {
         System.out.println("GetMin: "+min);
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
