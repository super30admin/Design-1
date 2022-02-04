
// Time Complexity : Push - O(1), Pop - O(n) since after popping the elem, checking iterating to find the min element present in the loop
// Space Complexity : O(N) - size of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MinStack {
    Stack<Integer> stack = null;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        if (stack != null) {
            stack.push(val);
            // System.out.println("Adding data "+val+", "+stack.size());
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        if (stack != null && stack.size() != 0) {
            // System.out.println("Removing data");
            stack.pop();
            // Poping and reseting the value to BIG value for comparision
            min = Integer.MAX_VALUE;
            // Loop the stack to get the min value
            for (Integer elem : stack) {
                // System.out.println("integer : "+elem+", min : "+min);
                if (elem < min) {
                    min = elem;
                }
            }

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