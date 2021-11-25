// Time Complexity : O(1) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

// Your code here along with comments explaining your approach

import java.util.Stack;

public class MinStack {

    // Have two stacks to track the numbers and the minimum at each push .
    Stack<Integer>numbers;
    Stack<Integer>minimum;
   
    
    public MinStack() {
        numbers=new Stack<Integer>();
        minimum=new Stack<Integer>();
        
    }
    public void push(int val) {
       
        int topvalue=val;
        if(!minimum.isEmpty())
            topvalue=minimum.peek();
        
        // Push the minimum of incoming number and the topvalue
        int minimum_val=Math.min(topvalue,val);
        numbers.push(val);
        minimum.push(minimum_val);
        
    }
    
    public void pop() {
        numbers.pop();
        minimum.pop();
        
    }
    
    public int top() {
        return numbers.peek();
    }
    
    public int getMin() {
        return minimum.peek();
        
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