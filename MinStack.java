// this implementation is to get the minimum value
// from the stack when the operations like push(), pop()  are performed.
/* the time complexity for all the operations here is O(1)*/
/*I implemented this method by using stack data structure*/
import java.util.Stack;
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }

    }

    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
    public static class Main{
        public static void main(String[] args){
            MinStack stack1 = new MinStack();
            stack1.push(1);
            stack1.push(0);
            stack1.push(-1);
            stack1.push(-2);
            stack1.push(-3);

            System.out.println(stack1.getMin());

            stack1.pop();
            stack1.pop();
            System.out.println(stack1.top());
            System.out.println(stack1.getMin());
        }
    }
}
