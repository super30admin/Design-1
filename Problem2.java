// https://leetcode.com/problems/min-stack/
// Time Complexity :
//      add: O(1)
//      remove: O(1)
//      contains: O(1) 

// Space Complexity :
//      add: O(1)
//      remove: O(1)
//      contains: O(1) 

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
//      To what scope do we define space complexity?
//      In this case we are using a stack to store the elements,
//      So, would I say that the space complexity of the class is O(N) where N is the number of elements?


// Your code here along with comments explaining your approach

import java.util.Stack;

class Problem2 {
    private Stack<Integer> st;
    private int min;

    public Problem2() {
        st=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min){
            // If we have a new min, we save the old min in stack
            st.push(min);
            min=val;
        }
        // The current val is not the new min
        st.add(val);
    }
    
    public void pop() {
        // Pop top element
        int top=st.pop();

        // If the top element was min, we need to update the min to old min
        // We saved the old min value in stack right before pushing the prev popped element
        if(min==top){
            min=st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
