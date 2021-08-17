// RUNTIME: O(1) for getting min
// SPACE: O(n)
// SUCCESS on LeetCode

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<int[]> stack;
    int top;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        top = -1;
    }
    
    public void push(int val) {
        if (this.min > val) {
            this.min = val;
        }
        int[] values = new int[]{val, this.min};
        stack.add(++top, values);
    }
    
    public void pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return;
        }
        top--;
    }
    
    public int top() {
        if (top > -1) {
            return stack.get(top)[0];
        }
        return -1;
    }
    
    public int getMin() {
        return stack.get(top)[1];
    }
}

class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        for (int i = 5; i > 0; i--) {
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
