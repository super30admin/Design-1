
//Time Complexity = O(1) and space complexity is O(n)
// We have used a supporting stack DS with a min Stack DS to keep a track of min value at any given time and an edge case of min duplicate is addressed by a check and removal of duplicate.

import java.util.*;

class MinStack {
  Stack<Integer> st;
  int min;

  public MinStack() {
    this.st = new Stack<>();
    this.min = Integer.MAX_VALUE;

  }

  public void push(int val) {
    if (val <= min) {
      st.push(min);
      min = val;
    }
    st.push(val);
  }

  public void pop() {
    if (min == st.pop()) {
      min = st.pop();
    }

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