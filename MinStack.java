import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> major;

    int min;

    private int size() {
        return major.size();
    }

    public MinStack() {
        stack = new Stack<>();
        major = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(major.isEmpty()) {
            min = Integer.MAX_VALUE;
        }
        if(val <= min) {
            min = val;
            stack.push(val);
        }
        major.push(val);
    }

    public void pop() {
        if(min == major.peek()) {
            stack.pop();

        }

        if(!stack.isEmpty()){
            min = stack.peek();
        }
        major.pop();
    }

    public int top() {
        return major.peek();

    }

    public int getMin() {
        if(stack.isEmpty()) {
            return stack.peek();
        }

        return Integer.MAX_VALUE;
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