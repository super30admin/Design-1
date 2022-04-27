//TC: O(1) -- each opr
//SC: O(n)


class MinStack {
    
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st =  new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min >= val){
            //prev min push to st (only if changing or equal)
            st.push(min);
            
            //reset min val
            min = val;
        }
        //always pushing elemnt on top 
        st.push(val);
    }
    
    public void pop() {
        if(min == st.pop() ){
            //reset min to prev min and pop it
            min = st.pop();
        }          
            
    }
    
    public int top() {
      return  st.peek();
    }
    
    public int getMin() {
        return min; //global min reset to curr min always
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