// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: We use only 1 stack in this approach, where we push the 'minimum' 
//first before pushing the actual element in the stack. We maintain the minimum in a variable.
// When we want to push an element, we check if its <= the current minimum,
// If it is then we push the minimum first then we set the minimum to the current element
// Then we push the element
// For pop operation, we check if the element being popped is same as the minimum, if so then
// we pop out another element which is the same as the previous minimum

public class MinStack_Approach2 {
    private Stack<Integer> st;
    private int min;
    
    public MinStack() {
        this.min=Integer.MAX_VALUE; //infinty
        this.st=new Stack<>();

    }
    
    public void push(int val) {
        if(val<=min){ // if val is <= minimum
            
            //prev min is pushed inside the stack below the element
            st.push(min); 
            
            // update the min value
            min=val;
        }
        
        // on top you will push val
        st.push(val);
    }
    
    public void pop() {
        if(st.pop() == min){ //if the popped element is = min
            min=st.pop(); // set to min and pop the element, this element would be the previous minimum
        }
    }
     
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}
