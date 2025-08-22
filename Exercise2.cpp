// Time Complexity : O(1)
// Space Complexity : O(n) for the two stack spaces we use
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
#include <bits/stdc++.h>
using namespace std;
class MinStack {
public:
  // Here we use two stacks one to push the elements, and one to maintain the
  // min element at each level
  stack<int> st1;
  // this is the stack that maintains the minimum elements
  stack<int> st2;

  MinStack() {}

  // In this , we normally push to stack1 (st1)
  // but for stack2, we first check if it's empty or not to handle the edge case
  // if it's not we check the top element, and min function to calculate the new
  // minimum and add that to stack2, so that each level we have an updated
  // minimum
  void push(int val) {
    st1.push(val);
    int minval = val;
    if (!st2.empty()) {
      minval = min(st2.top(), val);
    }
    st2.push(minval);
  }

  // here we pop from both the stacks so that we have the updated minimum in
  // stack 2 (st2)
  void pop() {
    st1.pop();
    st2.pop();
  }

  // This is an O(1) operation
  int top() { return st1.top(); }

  // This is an O(1) operation, since we directly return the top from st2
  int getMin() { return st2.top(); }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
