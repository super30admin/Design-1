//Time Complexity=O(1)
//Space Complexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {//We are maintaining 2 stacks one to store values and other to store min values
    Stack<Integer> st;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        st =new Stack<>();
        min = new Stack<>();
    }
    
    //During push we are ading to stack st and we are checking if there is an element in min stack is less then or equal to the value x, then we are adding it to the stack 
    public void push(int x) {
      st.push(x);
        if(min.isEmpty()){
           min.push(x);
          }
        else
        {
            if(min.peek()>=x)
                min.push(x);
        }
        
    }
    //We are checking if both the elements in top of stack is same then we are removing it from st as well as min stack;
    public void pop() {
       
        if(top() == min.peek())
        {
            min.pop();
        }
        st.pop();
    }
    //Top of st stack
    public int top() {
       return st.peek();
    }
    //top of min stack;
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */