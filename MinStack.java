//TC: O(1)
//SC: O(N)
import java.util.Stack;


public class MinStack {
    class StackElement {
        int value;
        int min;
        StackElement(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    
    Stack<StackElement> stack;
  
    public MinStack() {
        stack = new Stack<StackElement>();
    }

    public void push(int element) {
      if(stack.isEmpty()) {
        stack.push(new StackElement(element, element));
        return;
      }
      StackElement peek = stack.peek();
      int minimum = peek.min > element ? element: peek.min;
      stack.push(new StackElement(element, minimum));
    }

    public int pop() {
        return stack.pop().value;
    }

    public int peek() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

   public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(1);
    minStack.push(2);
    minStack.push(-238);
    minStack.push(6);
    minStack.push(8);
    minStack.push(-1);
    minStack.push(0);

    System.out.println("The minimum value is"+minStack.getMin());

   }
}
