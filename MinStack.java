// Time Complexity : push, pop, top and getMin run in O(1) time complexity.
// Space Complexity : O(2*n) worst case space complexity for when elements are pushed to stack in decreasing order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I use a single stack instead of two separate stacks in my approach. 
// At first I push Integer.MAX_VALUE into the stack.

import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() // Initialising the stack and min variable
    {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) // If minimum value is greater than or equal to current value, push it to the stack and update value of min to be equal to current value. Else just push current value to stack
    {
        if(min>=val)
        {
            st.push(min);
            min=val;
        }
        st.push(val);
    }
    
    public void pop() // Pop element from the stack, if that element is equal to the minimum value, pop another element from the stack and assign it to be equal to minimum value.
    {
        if(min==st.pop())
        {
            min=st.pop();
        }
    }
    
    public int top() //Return top element of stack
    {
        return st.peek();
    }
    
    public int getMin() //Return minimum value
    {
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