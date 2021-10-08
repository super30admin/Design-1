// Time complexity is O(1+lf), depends on the Load factor(lf): lf = n/m, n=number of elements stored in hash table and m=number of slots
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes (https://leetcode.com/submissions/detail/567066705/)
// Any problem you faced while coding this:

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (min >= val) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int top = stack.peek();
        if (!(stack.isEmpty()) && top == min) {
            stack.pop();
            min = stack.pop();
        } else if (!(stack.isEmpty())) {
            stack.pop();
        }
    }

    public int top() {
        int top = stack.peek();
        return top;
    }

    public int getMin() {
        return min;
    }
}

public class Problem2 {
    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top(); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
