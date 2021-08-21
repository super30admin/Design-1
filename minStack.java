// Time Complexity : push: O(1), pop: O(1), top: O(1), getMin: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MinStack {

    Stack<Integer> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        stack.push(min);
    }
    
    public void push(int val) {
       if(val <= min){
            stack.push(min);
           min = val;
       }
        stack.push(val);
        
    }
    
    public void pop() {
       // int val = stack.pop();
        if(stack.pop() == min){
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */