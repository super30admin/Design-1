//Problem 2 MinStack
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class MinStack {
    
    Stack<Integer> stack = new Stack();
    Stack<Integer> minimum = new Stack();
    public MinStack() {
        
    }
    
    public void push(int val) {
        
      stack.push(val);
      if(minimum.isEmpty() || minimum.peek() >= val) {
          minimum.push(val);
      }
        
    }
    
    public void pop() {
        
        if(stack.peek().equals(minimum.peek())){
            minimum.pop();
        }
           stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minimum.peek();
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
