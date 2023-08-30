//Time complexity : all push,pop,top and getMin take O(1) Tc
//Space Complexity : O(N) as we maintain two stacks
// All test cases passed in Leetcode
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int minValue;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minValue = Integer.MAX_VALUE;
        minStack.push(minValue);
    }

    public void push(int val) {
        if(val <= minValue){
            minValue = val;
        }
        stack.push(val);
        minStack.push(minValue);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        minValue = minStack.peek();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
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