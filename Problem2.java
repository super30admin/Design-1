import java.util.Stack;

/**
 * Use single stack to store both values and current min.
 * 1. First push Infinity to the stack.
 * 2. When pushing, check if the value is <= to current min.
 *      a) If true, push the previous min to the stack and assign current value to min and push the value.
 *      b) If false, just push the value to stack.
 * 3. When removing value, check if current value == min.
 *      a) If true, Pop the value and Pop the previous min and assign it to min.
 *      b) If false, just Pop top value.
 */
class MinStack {
    private final Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack.push(min);
    }

    public void push(int val) {
        if (min >= val) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
