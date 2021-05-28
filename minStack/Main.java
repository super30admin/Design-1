import java.util.Stack;

class MinStack {

    Stack<Integer> myStack;
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        //initialise min stack with max value of integer
        min = Integer.MAX_VALUE;
        //create two stacks, one is main stack to push and pop the given element and other one is to tack the  min element in the stack
        myStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }

    public void push(int val) {
        //push given value to my stack and current min on min stack
        min = Integer.min(min,val);
        myStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        // pop the element from the both the stack and update global min element
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
