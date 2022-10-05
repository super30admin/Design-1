// Time Complexity : O(1)
// Space Complexity : O(n) - Size of the stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {

  Stack<Integer>min_stack;
  int min;
  public MinStack() {
    min = Integer.MAX_VALUE;
    min_stack = new Stack<Integer>();
  }

  public void push(int val) {
    if(val <= min) {
      min_stack.push(min);
      min = val;
      min_stack.push(val);
    }
    else
      min_stack.push(val);
  }

  public void pop() {
    int value = min_stack.pop();
    if(value == min) {
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */