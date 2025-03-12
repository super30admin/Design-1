//My Approach : 
// I use two stacks—one for storing values and one for tracking the minimum. 
// The min stack always stores the smallest value up to that point. 
// Each push updates the min stack by comparing the new value with the current minimum.


// Time Complexity : O(1) for push, pop, top, getMin.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;
public class MinStack 
{
    Stack<Integer> act ;
    Stack<Integer> m ;
    int min;
    public MinStack() { 
        act = new Stack<>();
        m = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) 
    {
        if(act.isEmpty())
        {
            act.push(val);
            m.push(val);
        }
        else
        {
            min = Math.min(m.peek(),val);
            act.push(val);
            m.push(min);
        }
    }
    
    public void pop() 
    {
        if(!act.isEmpty())
        {
            act.pop();
            m.pop();
        }
    }
    
    public int top() {
        return act.peek();
    }
    
    public int getMin() {
        return m.peek();
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