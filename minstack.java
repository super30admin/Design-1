// Time Complexity : O(1) for all operations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class MinStack {
    Stack<Integer> min_stack;
    Integer min;
    
    /** initialize your data structure here. */
    public MinStack() {
        min_stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        min_stack.push(min);
    }
    
    public void push(int x) {
        if(x <= min){
            min_stack.push(min);
            min = x;
        }
        min_stack.push(x);
    }
    
    public void pop() {
        int pop_element = min_stack.pop();
        if(pop_element == min){
            min = min_stack.pop();
        }
    }
    
    public int top() {
        return min_stack.peek();
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