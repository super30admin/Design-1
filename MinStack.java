// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
  
    }
    
    public void push(int val) {
        stack.push(val);
        int min = val;
        if(!minstack.empty()){
            if(min > minstack.peek()){
                min = minstack.peek();
            }
        }
        minstack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
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