import java.util.Stack;

class MinStack {

    Stack<Integer> myStack;
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        myStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }

    public void push(int val) {
        min = Integer.min(min,val);
        myStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        myStack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return  myStack.peek();
    }

    public int getMin() {
        return min;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(2);
        System.out.println("minimum element of the stack is : " + ms.getMin());
        ms.pop();
        System.out.println("minimum element of the stack is : " + ms.getMin());
        ms.push(1);
        System.out.println("minimum element of the stack is : " + ms.getMin());
        ms.push(8);
        ms.pop();
        ms.pop();
        ms.pop();
    }
}
