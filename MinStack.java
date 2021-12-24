import java.util.Stack;

// TC - O(1) SC O(n)
class MinStack {
    Stack<Integer> stk;
    private int min;

    public MinStack() {
        stk = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            stk.push(min);
            min = val;
        }
        stk.push(val);
    }

    public void pop() {
        if (min == stk.pop()) {
            min = stk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return min;
    }
}

// TC - O(1) SC O(n)
class MinStack_TwoStacks {
    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack_TwoStacks() {
        stk = new Stack<Integer>();
        minStk = new Stack<Integer>();
    }

    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        }
    }

    public void pop() {
        if ((minStk.peek()).equals(stk.peek())) {
            minStk.pop();
        }
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}