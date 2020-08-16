class MinStack {

  Stack<Integer> mStack;
  Stack<Integer> stack;
  /** initialize your data structure here. */
  public MinStack() {
      this.mStack = new Stack<>();
      this.stack = new Stack<>();
  }
  
  public void push(int x) {
      stack.push(x);
      if(mStack.isEmpty() || mStack.peek() >= x) {
        mStack.push(x);
      }
  }
  
  public void pop() {
      if(stack.pop().equals(mStack.peek())) {
        mStack.pop();
      }
  }
  
  public int top() {
    return stack.peek();
      
  }
  
  public int getMin() {
    return mStack.peek();
      
  }
}
