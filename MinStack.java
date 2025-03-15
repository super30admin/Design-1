// Time Complexity :O(1) for every method push, pop, top, getMin
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Single stack is used to store values, min keeps track of the minimum value. 
// When pushing a new min, previous min is also pushed in the stack. 
// When popping, if the removed element is the min, the previous min is restored from the stack.


import java.util.*;

class MinStack {
    Stack<Integer> st;
    int min;
public MinStack() {
    this.st=new Stack<>();
    this.min=Integer.MAX_VALUE;
    
}

public void push(int val) {
    if(min>=val){
        st.push(min);
        min=val;
    }
    st.push(val);
}

public void pop() {
    if(st.pop()==min){
        min=st.pop();
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