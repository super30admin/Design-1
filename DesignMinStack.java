
class MinStack {

  Stack<int[]> stack;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<>();
  }

  //TC - O(1)
  //SC - O(1)
  public void push(int val) {
    if(stack.isEmpty()){
      stack.push(new int[]{val, val});
      return;
    }
    int[] element = stack.peek();

    int min = Math.min(val ,element[1]);
    stack.push(new int[]{val, min});
  }

  //TC - O(1)
  //SC - O(1)
  public void pop() {
    stack.pop();
  }

  //TC - O(1)
  //SC - O(1)
  public int top() {
    return stack.peek()[0];
  }

  //TC - O(1)
  //SC - O(1)
  public int getMin() {
    return stack.peek()[1];
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
