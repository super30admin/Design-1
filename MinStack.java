// For push operation O(1) time complexity
//For peek operatio O(1)
// pop operation O(1)
//top and getMIn o(1)
//Space Complexity o(n) extra space




class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
       st =  new Stack<>();
       minStack = new Stack<>();
       min = Integer.MAX_VALUE;
       minStack.push(min);
        
    }
    
    public void push(int value) {
        
        st.push(value);
        min = Math.min(min,value);
        minStack.push(min);
   
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
        
    }
    
    public int top() {
      return  st.peek();
        
    }
    
    public int getMin() {
     return   minStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */