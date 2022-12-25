// Time Complexity : push, pop, top, min all run in constant time O(1)
// Space Complexity : O(2n) as we are using an extra stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We solve this using an additional stack. 
// The additional stack has 1:1 mapping and keeps track of min value at every stage in the stack.


class MinStack {

    private int min;
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(this.min); //handles case where we try to find min in empty stack
    }
    
    public void push(int val) {
        st.push(val);
        if(val<min) 
            min = val;
        minSt.push(min); 
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek(); 
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