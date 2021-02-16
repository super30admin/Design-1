import java.util.Stack;

// In this approach I am maintainiing two stacks
// One main stack maintains the lements that is being inserted into the stack
// The other stack only holds the current minimum element in the stack. 
// When we want the current minimum element in the stack, we can get it in constant time

// Time Complexity : O(1) for all operations 

// Space Complexity : O(n) for the stacks. 

public class MinStack2 {

    Stack<Integer> stack;
    Stack<int[]> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[] { x, 1 });
        } else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        if (stack.peek() == minStack.peek()[0]) {
            minStack.peek()[1]--;
            if (minStack.peek()[1] == 0) {
                minStack.pop();
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }

    public static void main(String[] args) {
        MinStack1 s2 = new MinStack1();
        s2.push(5);
        s2.push(12);
        System.out.println("Current top of stack : " + s2.top());
        System.out.println("Current min element in the stack : " + s2.getMin());
        s2.push(1);
        s2.push(0);
        s2.pop();
        System.out.println("Current top of stack : " + s2.top());
        System.out.println("Current min element in the stack : " + s2.getMin());
    }
}
