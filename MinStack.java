// Time Complexity : O(1) as everything takes constant time.
// Space Complexity : O(2n) as I have used two stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : this statement s.peek().equals(minS.peek()) took so much time. I was using == to compare the values.
//had to refer to https://stackoverflow.com/questions/52224835/stack-peek-comparison-returns-wrong-result-for-1024 to solve the problem

// Your code here along with comments explaining your approach


import java.util.Stack;

class MinStack {
  Stack<Integer> s;
  Stack<Integer> minS;
  /** initialize your data structure here. */
  public MinStack() {
    s = new Stack<>();
    minS = new Stack<>();
  }

  public void push(int x) {
    s.push(x);
    if(minS.isEmpty() || minS.peek() >= x)
      minS.push(x);
  }

  public void pop() {
    if(s.peek().equals(minS.peek())){
      s.pop();
      minS.pop();
    }
    else
      s.pop();
  }

  public int top() {
    if(!s.isEmpty())
      return s.peek();
    return -1;
  }

  public int getMin() {
    if(!minS.isEmpty()){
      return minS.peek();
    }
    return -1;
  }

  public static void main(String[] args) {
    MinStack obj = new MinStack();
    obj.push(x);
    obj.pop();
    int param_3 = obj.top();
    int param_4 = obj.getMin();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */