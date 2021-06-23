class MinStack {

    //using two stacks
    //Time complexity- O(1) for given operations
    //Space complexity- O(N)

    Stack<Integer> st= new Stack<>();
    Stack<Integer> minst= new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
                  
        
        if(minst.isEmpty() || x<=minst.peek())
            minst.push(x);  
                    
            st.push(x);

    }
    
    public void pop() {
        
        if(st.peek().equals(minst.peek()))  minst.pop();
        
         st.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minst.peek();
    }
}