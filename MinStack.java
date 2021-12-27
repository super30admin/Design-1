// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> st;
    private int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE; //Set min value as infinity
    }
    
    public void push(int val) {
        
        //In pushing, if the current value being pushed is less than or equal to min value, push the previous min value first and then update the min value
        
        if(val<=min){ 
            st.push(min); //Pushing previous min value
            min = val; //Updating min value
        }
        st.push(val); //Pushing the value
    }
    
    public void pop() {
        //If the current value being popped is equal to the min value, then pop the next value and set it as min value 
        if(st.pop() == min){
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek(); //Returns top value of the stack
    }
    
    public int getMin() {
        return min; //Returns min value present in the stack
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
