import java.util.*;
public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s = new Stack<>();
    Stack<Integer> t = new Stack<>();

    public void push(int val) {
        s.push(val);
        int min = t.isEmpty() || val < t.peek() ? val : t.peek();
        t.push(min);
    }

    public void pop() {
        s.pop();
        t.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return t.peek();
    }
    public static void main (String[] args ){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}

