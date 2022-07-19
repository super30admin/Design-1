// Time Complexity : O(1) for all
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : was missing few edge cases which I fixed


import java.util.*;

class MinStack {
    Stack st;
    int min;
    class StackNode {
        int val;
        int min;
        
        StackNode(int data, int minimum) {
            val = data;
            min = minimum;
        }
    }
    public MinStack() {
        st = new Stack<StackNode>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(val,min);
        StackNode newNode = new StackNode(val, min);
        st.push(newNode);
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        st.pop();
         if(st.isEmpty())
            min=Integer.MAX_VALUE;
        else {
            StackNode node = (StackNode)st.peek();
            min = node.min;
        }
        
    }
    
    public int top() {
        if(st.isEmpty())
            return -1;
        StackNode node = (StackNode)st.peek();
        return node.val;
    }
    
    public int getMin() {
        if(st.isEmpty())
            return 0;
        StackNode node = (StackNode)st.peek();
        return node.min;
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
