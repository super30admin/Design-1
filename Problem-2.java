// Time Complexity: O(1) for all operations.
// Space Complexity: O(n), where n is the number of elements in the stack.

// Approach: Use two stacks, one to store all the elements and another to keep track of the minimum elements.
// Whenever a value is smaller than or equal to the current minimum, push it onto the minimum stack as well.
// While popping, remove the top element from both stacks if their top values are equal, so getMin() always returns the current minimum.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    Stack<Integer> s1;
    Stack<Integer> minStack;

    public MinStack() {
        s1 = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        s1.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (minStack.peek().equals(s1.peek())) {
            minStack.pop();
        }

        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
