// Time Complexity : o(1) for all operations
// Space Complexity : o(2n) => o(n) because we used 2 stacks approach
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {

    int min;
    Stack<Integer> st;
    Stack<Integer> minStack; 
    
    public MinStack() { 
        min = Integer.MAX_VALUE;    // initialize the stack and min in the constructor
        st = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min); // we push +infini into stack coz we need it present in base      
    }
    
    public void push(int val) {       
        if(val <= min) {
            min = val;
        }      
        st.push(val);
        minStack.push(min);   
    } 
    
    public void pop() {    
        st.pop();
        minStack.pop();
        min = minStack.peek();   // we need to update value of min after pop cuz we might have popped the recent min value    
    }
    
    public int top() {    
         return st.peek();    
    }
    
    public int getMin() {
        return min; 
    }
}