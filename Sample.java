// Time Complexity :Push-O(1),Pop-O(1),top-O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        
    }
    
    public void push(int val) {
        if(val <= min)
        {
            stack.push(min);    //Push the element
            min = val;        // Update the element in the stack
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min)
        {
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
