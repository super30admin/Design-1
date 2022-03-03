// Time Complexity :O(1)
// Space Complexity : used one array O(n), variables
// Did this code successfully run on Leetcode : yes

class MinStack {
    Stack<Integer> st;
    //Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.st = new Stack<>();
      //  this.minSt = new Stack<>();  
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min){
           // if(min != Integer.MAX_VALUE)
                st.push(min);
            min = val;
        }
        st.push(val);       
    }
    
    public void pop() {
        if(min == st.pop()){
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
