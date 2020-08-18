// Time Complexity : push - O(1), pop - O(1), top, getMin - O(1)
// Space Complexity : O(1) - As we are using same stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MinStack {

    private Stack<Integer> stack;
    private Integer min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(min >= x){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int popped = stack.pop();
        if(popped == min){
            min = stack.pop();
        }
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