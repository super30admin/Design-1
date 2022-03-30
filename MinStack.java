public class MinStack {
    /*
     * Time Complexity: O(1) for push, pop, top and
     * Space Complexity: O(2n) for stack and minStack
     * Author: Aditya Mulik
     */

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>(); // to maintain values in stack
        minStack = new Stack<>(); // to maintain min value
        minStack.push(min); // Have max value in the minStack
    }

    public void push(int val) {
        if (val < min) {
            min = val;
        }
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        System.out.println("Get Top " + stack.peek());
        return stack.peek();
    }

    public int getMin() {
        System.out.println("Get Min " + minStack.peek());
        return minStack.peek();
    }

    public static void main(String[] args) {
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