import java.util.Stack;
class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack();
    }

    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            min  = val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if (val == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(20);
        minStack.push(55);
        minStack.push(3);
        System.out.println("min -- " + minStack.getMin());
        minStack.getMin(); // return 3
        minStack.pop();
        System.out.println("top -- " + minStack.top());
        minStack.top();    // return 55
        System.out.println("min -- " + minStack.getMin());
        minStack.getMin(); // return 20
    }
}