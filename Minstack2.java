//Time complexity O(1)
//Space complexity O(N)
//successfully run in leetcode
//also done an approach using two stacks instead of two arrays. so the runtime and space are less



class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    int max;
    public MinStack() {                                                                             
        this.st = new Stack<Integer>();
        this.min = new Stack<Integer>();
        this.max = Integer.MAX_VALUE;
        min.push(max);
        
    }
    
    public void push(int val) {
       st.push(val);
        if(st.peek()<=min.peek()){
          min.push(st.peek());   
        }
        return;
    }
    
    public void pop() {
        
        if(st.peek()==min.peek()){
            min.pop();
        }
        st.pop();
        return;
        }
        
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
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