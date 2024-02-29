import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) { // Min is going to get updated here
            stack.push(min);  // We push the old min to stack to maintain record
            min = val; // We update the min variable
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min) { // If the popped element is equal to live min, 
            min = stack.pop(); // We update the live min. Also pop the previous mean from the stack. 
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */