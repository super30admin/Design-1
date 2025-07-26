// Time Complexity : O(1) for push, pop, top, and getMin operations
// Space Complexity : O(n) for the two stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) 
    {
        min = Math.min(min,val);
        st.push(val);
        minSt.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min= minSt.peek();
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

