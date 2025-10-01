import java.util.Stack;

/*
* Problem: Min stack
* Approach: Min Stack using two stacks. We use two stacks, one to maintain all the values being pushed and popped, and
* another to main the min elements. The min stack stores elements in pair in which first value is the min value and the
* second value is the frequency of that value to avoid repetitive push and pop operations of duplicate min values.
* */

// Time: O(1) for push(), pop(), top(), getMin() operations
// Space: O(n) as we use a space worth n elements to maintain the main and min stack

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top()); // 0
        System.out.println(minStack.getMin()); // -2
    }

    // This is the main stack
    private Stack<Integer> stack;

    // This is the min stack dedicated for storing minimum elements and their corresponding frequencies.
    private Stack<int[]> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push the value to the top of the stack. If min stack is empty or the top element is less than or equal to value,
    // we simply push the element on top of min stack with a default freq 1.
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()[0]) {
            minStack.push(new int[] {val, 1});
        } else if (val == minStack.peek()[0]) { // If value is already present on top of min stack, we increment the freq count
            minStack.peek()[1]++;
        }
    }

    // Pop the value from the top of main stack. Before popping, check if the value being removed is equal to the
    // top of the min stack. If it is we decrement the freq count by 1 and also check if the freq count is 0. If
    // it is 0, we don't need the value and it can be removed from min stack.
    public void pop() {
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }

        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        stack.pop();
    }

    // returns top of main stack
    public int top() {
        return stack.peek();
    }

    // returns top of min stack i.e. the min element
    public int getMin() {
        return minStack.peek()[0];
    }
}
