import java.util.Stack;

//Time Complexity: O(1)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class MinStack {

  private Stack<Integer> st = new Stack<>();
  private Stack<Integer> minSt = new Stack<>();
  private int min = Integer.MAX_VALUE;

  public MinStack() {
    minSt.push(min);
  }

  public void push(int val) {
    st.push(val);
    min = Math.min(min, val);
    minSt.push(min);
  }

  public void pop() {
    st.pop();
    minSt.pop();
    min = minSt.peek();
  }

  public int top() {
    return st.peek();
  }

  public int getMin() {
    return minSt.peek();
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
