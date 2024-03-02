// Time Complexity : Push, Peek, pop, min : O(1)
// Space Complexity : O(n) because we are using an extra space to keep track of minimum
// Did this code successfully run on Leetcode :Yes, https://leetcode.com/problems/min-stack/
// Any problem you faced while coding this : No

// The approach used in this case is that we have used two stacks, stack and minStack with 1:1 mapping where we will be pushing all the elements irrespective of 
//whether there is a change in minimum or not.

class MinStack {

     Stack<Integer> st;
     Stack<Integer> minSt;
     int min;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        this.minSt.push(min);
        this.st.push(val);
    }
    
    public void pop() {
        this.st.pop();
        this.minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
