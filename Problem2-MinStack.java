// Time Complexity : push(),pop(),top(),getMin() - O(1) 
// Space Complexity : to calculate min - O(1) store elements - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Note: I am implementing it after class and I am not sure how I would have done before the class 


// Your code here along with comments explaining your approach

class MinStack {
    
    private Stack<Integer> st; //To store values
    private int min; //To store minimum

    public MinStack() {
        // Initializing values
        this.st = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min) { //if the val is less than min, push prev min
            st.push(min);   
            min = val;
        }
        st.push(val); //push val
    }
    
    public void pop() {
        if(min == st.pop()){ //If the top is equal to min
            min = st.pop(); //pop again to get prev min
        }
    }
    
    public int top() {
        return st.peek();  //return the top element
    }
    
    public int getMin() {
        return this.min; //return the minimum element
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