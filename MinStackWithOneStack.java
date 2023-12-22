// Time Complexity : o(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class MinStackWithOneStack {
  Stack<Integer> st;
  int min;
  public MinStackWithOneStack() {
    this.min= Integer.MAX_VALUE;
    st= new Stack<Integer>();
  }

  public void push(int val) {
    st.push(min);
    st.push(val);

    min = Math.min(min, val);

  }

  public void pop() {
    st.pop();
    min= st.pop();
  }

  public int top() {
    return st.peek();
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
