// Time Complexity : o(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
      this.min= Integer.MAX_VALUE;
      st= new  Stack<Integer>();
      minSt= new  Stack<Integer>();
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
      min= minSt.peek();
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

//more efficient solution

//class MinStack {
//
//  Stack<Integer> st;
//  Stack<Integer> minSt;
//  int min;
//  public MinStack() {
//    this.min= Integer.MAX_VALUE;
//    st= new  Stack<Integer>();
//    minSt= new  Stack<Integer>();
//    minSt.push(min);
//  }
//
//  public void push(int val) {
//    st.push(val);
//    if(val<= min) {
//      minSt.push(val);
//      min = Math.min(min, val);
//    }
//  }
//
//  public void pop() {
//    int t =st.pop();
//    if(min==t){
//      minSt.pop();
//      min= minSt.peek();
//    }
//  }
//
//  public int top() {
//    return st.peek();
//  }
//
//  public int getMin() {
//    return min;
//  }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */