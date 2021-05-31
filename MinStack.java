// Problem 2:
//Design MinStack

class MinStack {

    private Stack<Integer> myStack;
    private Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        myStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(val, min);
        minStack.push(min);
        myStack.push(val);
    }

    public void pop() {
        myStack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
