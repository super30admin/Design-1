// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class MinStack {
    
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;        
    }
    
    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            stack.push(val);
            min = val;
        } 
        else {
            stack.push(val);
        }
        
    }
    
    public void pop() {

        if(stack.peek() == min) {
            stack.pop();
            min = stack.pop();            
        }
        else {
            stack.pop();
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