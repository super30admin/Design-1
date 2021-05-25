// Time Complexity : O(1)
// Space Complexity : O(N)

class DesignMinStack{

  Stack<int[]> stack;

  public DesignMinStack(){
    stack = new Stack();
  }

  public void push(int val){
    if(stack.isEmpty()){
      stack.push(new int[]{val, val});
      return;
    }

    int currentMinimum = stack.peek()[1];
    stack.push(new int[]{val, Math.min(currentMinimum, val)});
  }

  public int top(){
    return stack.peek()[0];
  }

  public int getMin(){
    return stack.peek()[1];
  }

  public void pop(){
    stack.pop();
  }
}
