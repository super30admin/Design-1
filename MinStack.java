// Time Complexity :1
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :min stack was not being updated
//this is new commeng-------------------

// Your code here along with comments explaining your approach

class MinStack {
    //making a stack 
    Stack<Integer> st=new Stack<>();
    //taking a variable min which holds greatest value 
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    //on first, we will puch the largest value(Infinity) in our stack
    public MinStack() {
        st.push(min);
        
    }
    //this function pushes the value in stack
    public void push(int x) { 
        //we have to keep track of min so if x is smaller update min to x
        if(x<=min)
        {
            st.push(min);
            min=x;
        }
        //push x in the stack
        st.push(x);  
        return;
    }
    
    public void pop() {
        //if min is on the top of the stack,pop it and give it the value of peek of the stack
        if(st.peek()==min)
        {
            st.pop();
            min=st.peek();
            
        }
        //pop the element from the stack
        st.pop();
        
    }
    
    public int top() {
        //return the uppermost element
       return st.peek();
        
    }
    
    public int getMin() {
        //simply return the min 
        return min;
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