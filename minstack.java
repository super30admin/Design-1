// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understood from the class


// Your code here along with comments explaining your approach
class MinStack {
     
    private Stack<Integer> stack;
        private int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min=Integer.MAX_VALUE;
        }
    
    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min=x;
        }stack.push(x);
        
    }
    
    public void pop() {
        int popped=stack.pop();
        if(popped==min){
            min=stack.pop();}
        }
        
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */