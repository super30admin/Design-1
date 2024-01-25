// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// st.pop() == minSt.peek() was giving false everytime, then realized was comparing integer to int. 


// Your code here along with comments explaining your approach

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) {
        st.push(val);
        if(val <= minSt.peek()){ // <= is to handle duplicate cases
            minSt.push(val);
        }
    }
    
    public void pop() {        
        if(st.pop() == (int)minSt.peek()){
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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