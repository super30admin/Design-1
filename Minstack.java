public class Minstack {

  int min;
  private Stack<Integer> stack;

  public void MinStack() {
    min = Integer.MAX_VALUE;
    stack = new Stack<>();
  }

  public void push(int val) {
    if (val <= min) {
      stack.push(min);
      min = val;
    }
    stack.push(val);
  }

  public void pop() {
    int val = stack.pop();
    if (val == min) min = stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
