//Approach:1 (approach 2 at line 46)

// Time Complexity : O(1)
// Space Complexity :O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Your code here along with comments explaining your approach

class MinStack {

  Stack<Integer> mainSt, st;
  int minVal = Integer.MAX_VALUE;

  /** initialize your data structure here. */
  public MinStack() {
    mainSt = new Stack<Integer>();
    st = new Stack<Integer>();
    st.push(minVal);
  }

  public void push(int val) {
    //pushing the element into the main stack
    mainSt.push(val);
    /*   if the current value is lesser than the top,
         then pushing the minimum value to the second stack,
         else pushing the top into the second stack */
    if (val < st.peek()) st.push(val); else st.push(st.peek());
  }

  //popping from both the stacks
  public void pop() {
    mainSt.pop();
    st.pop();
  }

  public int top() {
    return mainSt.peek();
  }

  public int getMin() {
    return st.peek();
  }
}

//Approach 2:
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Initially, I had failed cases with the negative values, later I dealt with those as well.

class MinStack {

  Stack<Integer> st;
  int minVal = Integer.MAX_VALUE;

  /** initialize your data structure here. */
  public MinStack() {
    st = new Stack<Integer>();
  }

  public void push(int val) {
    //checking if stack is empty, if so the minValue is the current value
    if (st.isEmpty()) {
      minVal = val;
      st.push(minVal);
      st.push(minVal);
    } else {
      st.push(val);
      if (val <= minVal) {
        minVal = val;
        st.push(minVal);
      } else st.push(minVal);
    }
  }

  public void pop() {
    st.pop();
    st.pop();
    //now minVal is changed, so overwriting the minValue.
    if (!st.isEmpty()) minVal = st.peek();
  }

  public int top() {
    //popping for once because the first element is the min value
    int temp2 = st.pop();
    int temp = st.peek();
    //again pushing the min value
    st.push(temp2);
    return temp;
  }

  public int getMin() {
    return st.peek();
  }
}
