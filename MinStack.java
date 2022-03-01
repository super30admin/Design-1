class MinStack {

  /*

    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
  */
    
  Deque<StackData> stack;
  
  public MinStack() {
      stack = new ArrayDeque<>();
  }
  
  /*
    Time Complexity: O(1)

    Space Complexity: O(1)
  */
  public void push(int val) {
      if(stack.isEmpty()){
          stack.push(new StackData(val, val));
      } else {
          stack.push(new StackData(val, Math.min(val, stack.peek().getMin())));
      }
  }
  
  /*
    Time Complexity: O(1)

    Space Complexity: O(1)
  */
  public void pop() {
      if(!stack.isEmpty()){
          stack.pop();
      }
  }
  
  /*
    Time Complexity: O(1)

    Space Complexity: O(1)
  */
  public int top() {
      return stack.peek().getData();
  }
  
  /*
    Time Complexity: O(1)

    Space Complexity: O(1)
  */
  public int getMin() {
      return stack.peek().getMin();
  }
}

/*
Class to store the element and rolling minimum together on the Stack.
*/ 
class StackData {
  
  int data, min;
  public StackData(int data, int min){
      this.data = data;
      this.min = min;
  }
  
  public int getMin(){
      return this.min;
  }
  
  public int getData() {
      return this.data;
  }
}
