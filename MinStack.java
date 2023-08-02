// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
* Create two stacks , one stack will be used to maintain all incoming values 
* Second stack will be used to maintain minimum value */
import java.util.Stack;

class MinStack {
    int minValue;
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;
        minStack.push(minValue);
    }

    public void push(int val) {
        minValue = Math.min(minValue, val);
        stack.push(val);
        minStack.push(minValue);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        minValue = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public void display() {
        System.out.print("Contents=");
        for (int x : stack) {
            System.out.print(x + ",");
        }
        System.out.println(" ");

    }
}

public class Sandbox {
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(1);
        m.push(2);
        m.display();
        System.out.println("Top=" + m.top());
        System.out.println("Minimum=" + m.getMin());
        m.pop();
        m.display();
        System.out.println("Minimum=" + m.getMin());
        m.display();
        System.out.println(m.top());
    }
}
