import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MinStack {

    /** initialize your data structure here. */
     Stack<int[]> stack1 = new Stack<>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        
        // 
          if (stack1.isEmpty()) {
            stack1.push(new int[]{val, val});
            return;
        }
        
        int currentMin = stack1.peek()[1];
        stack1.push(new int[]{val, Math.min(val, currentMin)});  // maintaining the corresponding minimum value in stack
        
    }
    
    public void pop() {
        stack1.pop();  // 
    }
    
    public int top() {
        return stack1.peek()[0]; // index 0 will fetch the top value of the stack
    }
    
    public int getMin() {
        return stack1.peek()[1]; // index 1 will fetch the minimum value 
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