# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
class MinStack {

    /** initialize your data structure here. */
 
        Stack<Integer> stack = new Stack();
        Stack<Integer> min_vals = new Stack();
   
    
    public void push(int val) {
      if(min_vals.isEmpty()||val<=min_vals.peek()){
          min_vals.push(val);
      }  
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(min_vals.peek())){
            min_vals.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_vals.peek();
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


